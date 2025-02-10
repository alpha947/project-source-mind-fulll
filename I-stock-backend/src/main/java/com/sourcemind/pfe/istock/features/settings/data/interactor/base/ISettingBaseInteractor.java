package com.sourcemind.pfe.istock.features.settings.data.interactor.base;


import com.sourcemind.pfe.istock.features.settings.data.dto.SettingRequest;
import com.sourcemind.pfe.istock.features.settings.domain.enums.SettingModule;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

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

public interface ISettingBaseInteractor {

    default ResponseEntity<SettingRequest> get(String key, SettingModule module) {
        return new ResponseEntity<>(new SettingRequest(), HttpStatus.OK);
    }

    ResponseEntity<SettingRequest> get(String key);

    ResponseEntity<List<SettingRequest>> getAll();

    ResponseEntity<Boolean> update(SettingRequest dto);

    ResponseEntity<Boolean> updateAll(List<SettingRequest> list);

}