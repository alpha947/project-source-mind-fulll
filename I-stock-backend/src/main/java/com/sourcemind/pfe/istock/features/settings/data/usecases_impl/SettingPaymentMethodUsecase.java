package com.sourcemind.pfe.istock.features.settings.data.usecases_impl;

import com.sourcemind.pfe.istock.core.annotations.Usecase;
import com.sourcemind.pfe.istock.features.settings.data.repository.SettingPaymentMethodRepository;
import com.sourcemind.pfe.istock.features.settings.domain.entity.SettingPaymentMethod;
import com.sourcemind.pfe.istock.features.settings.domain.usecase.ISettingPaymentMethodUsecase;
import lombok.RequiredArgsConstructor;

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
public class SettingPaymentMethodUsecase implements ISettingPaymentMethodUsecase {

    private final SettingPaymentMethodRepository repository;

    @Override
    public List<SettingPaymentMethod> all() {
        return this.repository.findAll();
    }

    @Override
    public Optional<SettingPaymentMethod> get(String title) {
        return this.repository.findByTitle(title);
    }

    @Override
    public Boolean updateMany(List<SettingPaymentMethod> settings) {
        return null;
    }

    @Override
    public Boolean update(String key, String value) {
        return null;
    }

    @Override
    public Optional<SettingPaymentMethod> getById(Long id) {
        return this.repository.findById(id);
    }


}