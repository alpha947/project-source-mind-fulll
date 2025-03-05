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
import com.sourcemind.pfe.istock.features.authentication.data.repository.RoleRepository;
import com.sourcemind.pfe.istock.features.authentication.domain.entity.Permission;
import com.sourcemind.pfe.istock.features.authentication.domain.entity.Role;
import com.sourcemind.pfe.istock.features.authentication.domain.usecase.IPermissionUsecase;
import com.sourcemind.pfe.istock.features.authentication.domain.usecase.IRoleUsecase;
import lombok.RequiredArgsConstructor;

import java.util.*;
import java.util.stream.LongStream;

import static com.sourcemind.pfe.istock.core.constants.Setting.DEFAULT_SYS_ROLE;

@Usecase
@RequiredArgsConstructor
public class RoleUsecaseImpl implements IRoleUsecase {
    private final RoleRepository repository;
    private final IPermissionUsecase usecase;

    @Override
    public Role save(Role role) {
        role.setPermissions(new HashSet<>(this.getFullPermissionObjectsFromRole(role)));
        return this.repository.save(role);
    }

    @Override
    public List<Role> getAll() {
        return this.repository.findAll();
    }

    @Override
    public boolean isNotSystemRole(Role role) {
        return !role.getName().equals(DEFAULT_SYS_ROLE);
    }

    @Override
    public Optional<Role> getOne(Long id) {
        return this.repository.findById(id);
    }

    public boolean isRoleExist(Long id) {
        return this.getOne(id).isPresent();
    }

    @Override
    public Set<Permission> getRolePermissions(Long id) {
        Optional<Role> optional = this.getOne(id);
        return optional.map(Role::getPermissions).orElse(new HashSet<>());
    }

    @Override
    public Optional<Role> update(Role roleToUpdate) {
        Optional<Role> optionalRole = this.getOne(roleToUpdate.getId());
        return optionalRole.map(role -> mapRoleBeforeUpdate(roleToUpdate, role));
    }

    private Role mapRoleBeforeUpdate(Role roleToUpdate, Role existingRole) {
        existingRole.setName(roleToUpdate.getName());
        existingRole.setDescription(roleToUpdate.getDescription());
        existingRole.setPermissions(roleToUpdate.getPermissions());
        return this.save(existingRole);
    }


    @Override
    public Optional<Boolean> updateActiveStatus(Long id) {
        Optional<Role> optional = this.getOne(id);
        return optional.map(role -> this.updateRoleActiveStatus(role.getId(), !role.getIsActiveStatus()));
    }

    private Collection<Permission> getFullPermissionObjectsFromRole(Role role) {
        LongStream streamOfPermissionIds = role.getPermissions().stream().mapToLong(Permission::getId);
        return usecase.getPermissionsByIds(streamOfPermissionIds);
    }

    private Boolean updateRoleActiveStatus(Long id, Boolean status) {
        int result = this.repository.updateActiveStatus(status, id);
        return result == 1;
    }


}
