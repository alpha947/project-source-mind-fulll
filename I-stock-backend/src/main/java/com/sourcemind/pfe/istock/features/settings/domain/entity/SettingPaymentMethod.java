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


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

import static com.sourcemind.pfe.istock.core.constants.Table.SETTING_PAYMENT_METHOD;

@Entity
@Table(name = SETTING_PAYMENT_METHOD)
@Data
public class SettingPaymentMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(updatable = false, unique = true)
    private String title;
    private String description;
    @Column(updatable = false)
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;

    public SettingPaymentMethod(String title) {
        this.title = title;
    }

    public SettingPaymentMethod() {
    }

    @PrePersist()
    void prePersist() {
        this.setCreatedAt(LocalDateTime.now());
    }

}