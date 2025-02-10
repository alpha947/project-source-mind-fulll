package com.sourcemind.pfe.istock.features.authentication.domain.usecase;
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
import com.sourcemind.pfe.istock.features.authentication.domain.entity.Permission;
import com.sourcemind.pfe.istock.features.authentication.domain.entity.Role;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface IRoleUsecase {

    Role save(Role role);

    List<Role> getAll();

    boolean isNotSystemRole(Role role);

    Optional<Role> getOne(Long id);

    Set<Permission> getRolePermissions(Long id);

    Optional<Role> update(Role role);

    Optional<Boolean> updateActiveStatus(Long id);
}
