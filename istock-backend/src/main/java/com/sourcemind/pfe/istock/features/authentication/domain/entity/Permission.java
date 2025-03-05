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

package com.sourcemind.pfe.istock.features.authentication.domain.entity;

import com.sourcemind.pfe.istock.features.authentication.domain.enums.AppModuleEnum;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

import static com.sourcemind.pfe.istock.core.constants.Table.AUTH_PERMISSION;


@Data
@Builder
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = AUTH_PERMISSION)
@AllArgsConstructor
@ToString
@EntityListeners(AuditingEntityListener.class)
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column
    private AppModuleEnum module;

    public Permission(String name, AppModuleEnum module) {
        this.name = name;
        this.module = module;
    }

    public Permission() {
    }

    public Permission(Long id) {
        this.id = id;
    }
}
