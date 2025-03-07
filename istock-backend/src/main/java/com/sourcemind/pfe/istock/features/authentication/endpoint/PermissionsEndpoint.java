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

import com.sourcemind.pfe.istock.features.authentication.data.interactor.contract.IPermissionInteractor;
import com.sourcemind.pfe.istock.features.authentication.data.request.PermissionGroupRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.sourcemind.pfe.istock.core.constants.Global.API_PREFIX;

@RestController
@RequestMapping(value = API_PREFIX + "/auth/permission")
@RequiredArgsConstructor
public class PermissionsEndpoint {
    private final IPermissionInteractor interactor;

    @GetMapping(value = "/all")
    ResponseEntity<List<PermissionGroupRequest>> getAllPermissionsGroupedByModule() {
        return interactor.getAllGroupedByModule();
    }

}
