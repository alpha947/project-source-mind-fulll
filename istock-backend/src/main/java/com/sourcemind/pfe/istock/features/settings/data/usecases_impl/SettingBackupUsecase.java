package com.sourcemind.pfe.istock.features.settings.data.usecases_impl;

import com.sourcemind.pfe.istock.core.annotations.Usecase;
import com.sourcemind.pfe.istock.features.settings.data.repository.SettingBackupRestoreRepository;
import com.sourcemind.pfe.istock.features.settings.domain.entity.SettingBackUpRestore;
import com.sourcemind.pfe.istock.features.settings.domain.usecase.ISettingUsecase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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

@Usecase
@RequiredArgsConstructor
@Slf4j
public class SettingBackupUsecase implements ISettingUsecase<SettingBackUpRestore> {

    private final SettingBackupRestoreRepository repository;

    @Override
    public List<SettingBackUpRestore> all() {
        return this.repository.findAll();
    }

    @Override
    public Optional<SettingBackUpRestore> get(String key) {
        return this.repository.findBySettingKey(key);
    }

    @Transactional
    public Boolean updateMany(List<SettingBackUpRestore> settings) {
        try {
            settings.forEach(s -> this.update(s.getSettingKey(), s.getSettingValue()));
            return true;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
    }

    @Transactional
    public Boolean update(String key, String value) {
        var optionalSetting = this.get(key);
        return optionalSetting.map(e -> {
            var updated = this.repository.updateByKey(key, value);
            return updated == 1;
        }).orElse(false);
    }
}