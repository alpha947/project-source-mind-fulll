package com.sourcemind.pfe.istock.features.settings.data.interactor.setting_company;

import com.sourcemind.pfe.istock.core.annotations.Interactor;
import com.sourcemind.pfe.istock.features.company.domain.usecase.ICompanyAdministratorSetupUsecase;
import com.sourcemind.pfe.istock.features.company.domain.usecase.ICompanyBasicDetailUsecase;
import com.sourcemind.pfe.istock.features.company.domain.usecase.ICompanyRegionSetupUsecase;
import com.sourcemind.pfe.istock.features.settings.data.dto.SettingRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.sourcemind.pfe.istock.core.constants.CompanyDetailConstant.*;
import static com.sourcemind.pfe.istock.features.settings.domain.enums.SettingModule.COMPANY;
import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.util.ObjectUtils.isEmpty;

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

@Interactor
@RequiredArgsConstructor
public class SettingCompanyInteractor implements ISettingCompanyInteractor {

    private final ICompanyBasicDetailUsecase basicDetails;
    private final ICompanyRegionSetupUsecase regionUsecase;
    private final ICompanyAdministratorSetupUsecase administratorSetupUsecase;

    @Override
    public ResponseEntity<SettingRequest> get(String key) {
        SettingRequest request = this.findIfKeyContains(key);
        return new ResponseEntity<>(request, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<SettingRequest>> getAll() {
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Boolean> update(SettingRequest dto) {
        if (dto.getSettingModule().equals(COMPANY)) {
            Optional<Boolean> optionalBoolean = this.updateIfKeyContains(dto);
            return ok().body(optionalBoolean.orElse(false));
        }
        return ok().body(false);
    }

    @Override
    public ResponseEntity<Boolean> updateAll(List<SettingRequest> list) {
        return null;
    }

    private SettingRequest findIfKeyContains(String key) {
        if (key.contains(COMPANY_REGION)) {
            return SettingRequest.fromModel(this.regionUsecase.getAsSetting(key));
        } else if (key.contains(COMPANY_PROFILE)) {
            return SettingRequest.fromModel(this.administratorSetupUsecase.getAsSetting(key));
        } else if (key.contains(COMPANY_BUSINESS)) {
            return SettingRequest.fromModel(this.basicDetails.getAsSetting(key));
        } else {
            return new SettingRequest();
        }
    }

    private Optional<Boolean> updateIfKeyContains(SettingRequest request) {

        String settingKey = request.getSettingKey();
        String settingValue = request.getSettingValue();

        if (!isEmpty(settingKey) && settingKey.contains(COMPANY_REGION)) {
            return this.regionUsecase.update(settingKey, settingValue);

        } else if (!isEmpty(settingKey) && settingKey.contains(COMPANY_PROFILE)) {
            return this.administratorSetupUsecase.update(settingKey, settingValue);

        } else if (!isEmpty(settingKey) && settingKey.contains(COMPANY_BUSINESS)) {
            return this.basicDetails.update(settingKey, settingValue);

        } else {
            return Optional.empty();
        }
    }

}