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

package com.sourcemind.pfe.istock.features.settings.endpoint;

import com.sourcemind.pfe.istock.features.settings.data.dto.SettingRequest;
import com.sourcemind.pfe.istock.features.settings.data.interactor.base.SettingInteractor;
import com.sourcemind.pfe.istock.features.settings.domain.enums.SettingModule;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.sourcemind.pfe.istock.core.constants.Global.API_PREFIX;

@RestController
@RequestMapping(value = API_PREFIX + "/setting")
@RequiredArgsConstructor
public class SettingEndpoint {

    private final SettingInteractor interactor;

    @GetMapping(value = "/find")
    public ResponseEntity<SettingRequest> getSettingByKeyAndModule(
            @RequestParam() String key,
            @RequestParam() SettingModule module
    ) {
        return this.interactor.get(key, module);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<Boolean> updateSettingByKeyAndModule(@RequestBody SettingRequest request) {
        return this.interactor.update(request);
    }


}
