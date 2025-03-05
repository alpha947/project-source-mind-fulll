package com.sourcemind.pfe.istock.features.settings.endpoint;

import com.sourcemind.pfe.istock.features.settings.data.dto.SettingRequest;
import com.sourcemind.pfe.istock.features.settings.data.interactor.setting_sale.ISettingSaleInteractor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.sourcemind.pfe.istock.core.constants.Global.API_PREFIX;

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

@RestController
@RequestMapping(value = API_PREFIX + "/setting-sale")
@RequiredArgsConstructor
public class SettingSalesEndpoint {

    private final ISettingSaleInteractor interactor;

    @GetMapping()
    public ResponseEntity<SettingRequest> get(@RequestParam() String key) {
        return this.interactor.get(key);
    }

    @GetMapping(value = "all")
    public ResponseEntity<List<SettingRequest>> getAll() {
        return interactor.getAll();
    }

    @PostMapping(value = "update-all")
    public ResponseEntity<Boolean> updateAll(@RequestBody List<SettingRequest> list) {
        return interactor.updateAll(list);
    }

    @PutMapping(value = "update")
    public ResponseEntity<Boolean> update(@RequestBody SettingRequest setting) {
        return interactor.update(setting);
    }

}