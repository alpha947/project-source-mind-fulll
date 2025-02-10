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
package com.sourcemind.pfe.istock.features.authentication.data.interactor.implementation;

import com.sourcemind.pfe.istock.core.annotations.Interactor;
import com.sourcemind.pfe.istock.core.mapper.Mapper;
import com.sourcemind.pfe.istock.features.authentication.data.interactor.contract.IPermissionInteractor;
import com.sourcemind.pfe.istock.features.authentication.data.request.PermissionGroupRequest;
import com.sourcemind.pfe.istock.features.authentication.data.request.PermissionRequest;
import com.sourcemind.pfe.istock.features.authentication.domain.entity.Permission;
import com.sourcemind.pfe.istock.features.authentication.domain.usecase.IPermissionUsecase;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.http.ResponseEntity.ok;

@Interactor
@RequiredArgsConstructor
public class PermissionInteractorImpl implements IPermissionInteractor, Mapper<PermissionRequest, Permission> {
    private final IPermissionUsecase usecase;
    private final ModelMapper mapper;


    @Override
    public ResponseEntity<List<PermissionRequest>> getAll() {
        List<Permission> permissions = this.usecase.getAll();
        return ok().body(permissions.stream().map(this::toRequest).collect(Collectors.toList()));
    }

    @Override
    public ResponseEntity<Optional<PermissionRequest>> getOne(Long id) {
        Optional<Permission> optional = this.usecase.getById(id);
        return ok().body(optional.map(this::toRequest));
    }

    @Override
    public PermissionRequest toRequest(Permission model) {
        return this.mapper.map(model, PermissionRequest.class);
    }

    @Override
    public Permission toModel(PermissionRequest request) {
        return this.mapper.map(request, Permission.class);
    }

    @Override
    public ResponseEntity<List<PermissionGroupRequest>> getAllGroupedByModule() {
        List<Permission> permissions = this.usecase.getAll();
        List<PermissionGroupRequest> collect = permissions.stream()
                .map(this::toRequest)
                .collect(Collectors.groupingBy(PermissionRequest::getModule))
                .entrySet()
                .stream()
                .map(entry -> new PermissionGroupRequest(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
        return ok().body(collect);
    }
}
