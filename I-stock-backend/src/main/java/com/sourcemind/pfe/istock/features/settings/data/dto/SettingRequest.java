package com.sourcemind.pfe.istock.features.settings.data.dto;

import com.sourcemind.pfe.istock.core.constants.enums.SettingField;
import com.sourcemind.pfe.istock.features.settings.domain.entity.Setting;
import com.sourcemind.pfe.istock.features.settings.domain.entity.SettingOption;
import com.sourcemind.pfe.istock.features.settings.domain.enums.SettingModule;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Collection;

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

@Data
@Builder
@AllArgsConstructor
public class SettingRequest {
    private Long id;
    private String settingKey;
    private String settingValue;
    private SettingField settingField;
    private String settingTitle;
    private Collection<SettingOption> settingOptions;
    private String settingHint;
    private SettingModule settingModule;

    public SettingRequest(String settingKey, String settingValue) {
        this.settingKey = settingKey;
        this.settingValue = settingValue;
    }

    public SettingRequest() {
    }

    public static SettingRequest fromModel(Setting model) {
        return new SettingRequest(model.getSettingKey(), model.getSettingValue());
    }
}