/*
 * @Author: james.junior
 * @Date: 7/14/23 10:16
 *
 * @Project: stocky-api
 */

package com.sourcemind.pfe.istock.features.settings.domain.entity;
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


import com.sourcemind.pfe.istock.core.constants.enums.SettingField;
import com.sourcemind.pfe.istock.features.settings.domain.enums.SettingModule;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class SettingObj {
    Long id;
    String key;
    String value;
    SettingField field;
    //Map<String, String> options = new HashMap<>();
    List<SettingOption> options = new ArrayList<>();
    String title;
    String hint;
    SettingModule module;

    public SettingObj() {
    }

    public SettingObj(String key, String value, SettingField field, String title, SettingModule module) {
        this.key = key;
        this.value = value;
        this.field = field;
        this.title = title;
        this.module = module;
    }

    public SettingObj(String key, String value, SettingField field, String title, SettingModule module, String hint) {
        this.key = key;
        this.value = value;
        this.field = field;
        this.hint = hint;
        this.module = module;
        this.title = title;
    }

    public SettingObj(
            String key,
            String value,
            SettingField field,
            String title,
            SettingModule module,
            String hint,
            List<SettingOption> options
    ) {
        this.key = key;
        this.value = value;
        this.field = field;
        this.hint = hint;
        this.module = module;
        this.title = title;
        this.options = options;
    }


}
