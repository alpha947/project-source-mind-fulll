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
import com.sourcemind.pfe.istock.features.authentication.domain.entity.User;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface IUserUsecase {

    User save(User user);

    Optional<User> findOne(Long id);

    Optional<User> findByUsername(String username);

    Optional<User> update(User user);

    Optional<Boolean> toggleActiveStatus(Long id);

    List<User> findMany();

    void checkDuplicateUsername(String username);

    List<String> findUserPermissionsNameOnly(User user);

    Boolean updateExpiryDate(Long userId, LocalDate date);

    Boolean updateRoles(Long userId, Collection<Long> rolesId);

    Boolean updatePassword(Long userId, String password);
}
