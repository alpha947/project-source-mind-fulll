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
package com.sourcemind.pfe.istock.features.authentication.data.usecase_impl;

import com.sourcemind.pfe.istock.core.annotations.Usecase;
import com.sourcemind.pfe.istock.features.authentication.data.repository.PermissionRepository;
import com.sourcemind.pfe.istock.features.authentication.domain.entity.Permission;
import com.sourcemind.pfe.istock.features.authentication.domain.usecase.IPermissionUsecase;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.LongStream;

@Usecase
@RequiredArgsConstructor
public class PermissionUsecaseImpl implements IPermissionUsecase {
    private final PermissionRepository repository;

    @Override
    public List<Permission> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Optional<Permission> getById(Long id) {
        return this.repository.findById(id);
    }

    @Override
    public Collection<Permission> getPermissionsByIds(LongStream list) {
        List<Permission> permissions = new ArrayList<>();
        list.forEach(id -> this.getById(id).ifPresent(permissions::add));
        return permissions;
    }

}
