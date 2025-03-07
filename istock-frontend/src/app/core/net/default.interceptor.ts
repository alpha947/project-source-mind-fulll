import {HttpErrorResponse, HttpEvent, HttpHandler, HttpHeaders, HttpInterceptor, HttpRequest, HttpResponseBase} from '@angular/common/http';
import {Injectable, Injector} from '@angular/core';
import {Router} from '@angular/router';

import {DA_SERVICE_TOKEN, ITokenService} from '@delon/auth';
import {_HttpClient, ALAIN_I18N_TOKEN, IGNORE_BASE_URL} from '@delon/theme';

import {environment} from '@env/environment';

import {NzNotificationService} from 'ng-zorro-antd/notification';

import {BehaviorSubject, catchError, filter, mergeMap, Observable, of, switchMap, take, throwError} from 'rxjs';

const CODEMESSAGE: {[key: number]: string} = {
    200: 'Le serveur a renvoyé avec succès les données demandées.',
    201: 'Les nouvelles données ou les données modifiées ont été traitées avec succès.',
    202: 'La demande a été placée dans la file d\'attente de fond (tâche asynchrone).',
    204: 'Les données ont été supprimées avec succès.',
    400: 'Il y a eu une erreur dans la requête envoyée, et le serveur n\'a pas créé ni modifié de données.',
    401: 'L\'utilisateur n\'a pas l\'autorisation (token, nom d\'utilisateur, mot de passe incorrects).',
    403: 'L\'utilisateur est autorisé, mais l\'accès est interdit.',
    404: 'La demande a été faite pour un enregistrement qui n\'existe pas, et le serveur n\'a pas effectué d\'opération.',
    406: 'Le format demandé n\'est pas disponible.',
    410: 'La ressource demandée a été supprimée de manière permanente et ne sera plus disponible.',
    422: 'Une erreur de validation est survenue lors de la création d\'un objet.',
    500: 'Le serveur a rencontré une erreur, veuillez vérifier le serveur.',
    502: 'Mauvaise passerelle.',
    503: 'Le service est indisponible, le serveur est temporairement surchargé ou en maintenance.',
    504: 'Délai d\'attente de la passerelle expiré.'
};


@Injectable()
export class DefaultInterceptor implements HttpInterceptor {
    private refreshTokenEnabled = environment.api.refreshTokenEnabled;
    private refreshTokenType: 're-request' | 'auth-refresh' = environment.api.refreshTokenType;
    private refreshToking = false;
    private refreshToken$: BehaviorSubject<any> = new BehaviorSubject<any>(null);

    constructor(private injector: Injector) {
        if (this.refreshTokenType === 'auth-refresh') {
            this.buildAuthRefresh();
        }
    }

    private get notification(): NzNotificationService {
        return this.injector.get(NzNotificationService);
    }

    private get tokenSrv(): ITokenService {
        return this.injector.get(DA_SERVICE_TOKEN);
    }

    private get http(): _HttpClient {
        return this.injector.get(_HttpClient);
    }

    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        let url = req.url;
        if (
            !req.context.get(IGNORE_BASE_URL) &&
            !url.startsWith('https://') &&
            !url.startsWith('http://')
        ) {
            const {baseUrl} = environment.api;
            url = baseUrl + (baseUrl.endsWith('/') && url.startsWith('/') ? url.substring(1) : url);
        }

        const newReq = req.clone({url, setHeaders: this.getAdditionalHeaders(req.headers)});
        return next.handle(newReq).pipe(
            mergeMap((ev) => {
                if (ev instanceof HttpResponseBase) {
                    return this.handleData(ev, newReq, next);
                }
                return of(ev);
            })
            // catchError((err: HttpErrorResponse) => this.handleData(err, newReq, next))
        );
    }

    private goTo(url: string): void {
        setTimeout(() => this.injector.get(Router).navigateByUrl(url));
    }

    private checkStatus(ev: HttpResponseBase): void {
        if ((ev.status >= 200 && ev.status < 300) || ev.status === 401) {
            return;
        }

        const errortext = CODEMESSAGE[ev.status] || ev.statusText;
        this.notification.error(`请求错误 ${ev.status}: ${ev.url}`, errortext);
    }

    private refreshTokenRequest(): Observable<any> {
        const model = this.tokenSrv.get();
        return this.http.post(`/api/auth/refresh`, null, null, {
            headers: {refresh_token: model?.['refresh_token'] || ''}
        });
    }

    private tryRefreshToken(
        ev: HttpResponseBase,
        req: HttpRequest<any>,
        next: HttpHandler
    ): Observable<any> {
        if ([`/api/auth/refresh`].some((url) => req.url.includes(url))) {
            this.toLogin();
            return throwError(() => ev);
        }
        if (this.refreshToking) {
            return this.refreshToken$.pipe(
                filter((v) => !!v),
                take(1),
                switchMap(() => next.handle(this.reAttachToken(req)))
            );
        }
        this.refreshToking = true;
        this.refreshToken$.next(null);

        return this.refreshTokenRequest().pipe(
            switchMap((res) => {
                this.refreshToking = false;
                this.refreshToken$.next(res);
                this.tokenSrv.set(res);
                return next.handle(this.reAttachToken(req));
            }),
            catchError((err) => {
                this.refreshToking = false;
                this.toLogin();
                return throwError(() => err);
            })
        );
    }

    private reAttachToken(req: HttpRequest<any>): HttpRequest<any> {
        const token = this.tokenSrv.get()?.token;
        return req.clone({
            setHeaders: {
                token: `Bearer ${token}`
            }
        });
    }

    private buildAuthRefresh(): void {
        if (!this.refreshTokenEnabled) {
            return;
        }
        this.tokenSrv.refresh
            .pipe(
                filter(() => !this.refreshToking),
                switchMap((res) => {
                    console.log(res);
                    this.refreshToking = true;
                    return this.refreshTokenRequest();
                })
            )
            .subscribe({
                next: (res) => {
                    // TODO: Mock expired value
                    res.expired = +new Date() + 1000 * 60 * 5;
                    this.refreshToking = false;
                    this.tokenSrv.set(res);
                },
                error: () => this.toLogin()
            });
    }

    private toLogin(): void {
        this.notification.error(`未登录或登录已过期，请重新登录。`, ``); //basic template configuration
        this.goTo(this.tokenSrv.login_url!);
    }

    private handleData(
        ev: HttpResponseBase,
        req: HttpRequest<any>,
        next: HttpHandler
    ): Observable<any> {
        this.checkStatus(ev);
        switch (ev.status) {
            case 200:
                break;
            case 401:
                if (this.refreshTokenEnabled && this.refreshTokenType === 're-request') {
                    return this.tryRefreshToken(ev, req, next);
                }
                this.toLogin();
                break;
            case 403:
            case 404:
            case 500:
                // this.goTo(`/exception/${ev.status}?url=${req.urlWithParams}`);
                break;
            default:
                if (ev instanceof HttpErrorResponse) {
                    console.warn('Warning', ev);
                }
                break;
        }
        if (ev instanceof HttpErrorResponse) {
            return throwError(() => ev);
        } else {
            return of(ev);
        }
    }

    private getAdditionalHeaders(headers?: HttpHeaders): {[name: string]: string} {
        const res: {[name: string]: string} = {};
        const lang = this.injector.get(ALAIN_I18N_TOKEN).currentLang;
        if (!headers?.has('Accept-Language') && lang) {
            res['Accept-Language'] = lang;
        }

        return res;
    }
}
