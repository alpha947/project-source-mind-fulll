/**
 * ==========================================================
 * Projet de fin d'études - SourceMind
 *
 * Développé par l'équipe Groupe 1 :
 *  - Alpha Amadou DIALLO (https://github.com/alpha947)
 *    Email : dialloalphaamadou947@gmail.com
 *  - Kouloube KOLIE (https://github.com/kouloube)
 *    Email : kouloubekolie@gmail.com
 *  - Moussa CAMARA (https://github.com/usermoussa)
 *    Email : moussaccamaraa@gmail.com
 *  - Mohamed Mouctar KABA (https://github.com/Mokaba-lab)
 *    Email : mocktarkba@gmail.com
 *
 * Ce projet Spring Boot a été conçu et développé
 * pour démontrer nos compétences techniques et
 * apporter une solution innovante.
 * ==========================================================
 */

package com.sourcemind.pfe.istock.features.authentication.endpoint;

import com.sourcemind.pfe.istock.core.params.PageSearchRequest;
import com.sourcemind.pfe.istock.core.params.PageSearchResult;
import com.sourcemind.pfe.istock.features.authentication.data.interactor.contract.IAccountInteractor;
import com.sourcemind.pfe.istock.features.authentication.data.request.AccountRequest;
import com.sourcemind.pfe.istock.features.company.data.request.CompanyEmployeeSearchRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.sourcemind.pfe.istock.core.constants.Global.API_PREFIX;

@RestController
@RequestMapping(value = API_PREFIX + "/auth/account")
@RequiredArgsConstructor
public class AccountEndpoint {

    private final IAccountInteractor interactor;

    @PostMapping(value = "/search")
    public ResponseEntity<PageSearchResult<List<AccountRequest>>> searchForUsersAccountInPages(
            @RequestBody PageSearchRequest<CompanyEmployeeSearchRequest> request) {
        return this.interactor.search(request);
    }

    @PutMapping(value = "/update-expiry-date/{userId}")
    public ResponseEntity<Boolean> updateExpiryDate(@PathVariable Long userId, @RequestBody AccountRequest request) {
        return interactor.updateExpiryDate(userId, request);
    }

    @PutMapping(value = "/update-role/{userId}")
    public ResponseEntity<Boolean> updateRole(@PathVariable Long userId, @RequestBody AccountRequest request) {
        return interactor.updateRoles(userId, request);
    }

    @PutMapping(value = "/update-password/{userId}")
    public ResponseEntity<Boolean> updatePassword(@PathVariable Long userId, @RequestBody AccountRequest request) {
        return interactor.updatePassword(userId, request);
    }

    @PutMapping(value = "/toggle-status/{userId}")
    public ResponseEntity<Boolean> toggleStatus(@PathVariable Long userId) {
        return interactor.toggleStatus(userId);
    }

}
