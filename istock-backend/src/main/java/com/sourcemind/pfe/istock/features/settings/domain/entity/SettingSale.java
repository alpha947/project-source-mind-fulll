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


import javax.persistence.Entity;
import javax.persistence.Table;

import static com.sourcemind.pfe.istock.core.constants.Table.SETTING_SALE;

@Entity
@Table(name = SETTING_SALE)
public class SettingSale extends Setting {

    public SettingSale() {
    }

    public SettingSale(SettingObj obj) {
        super(obj);
    }
}