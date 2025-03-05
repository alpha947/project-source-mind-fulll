package com.sourcemind.pfe.istock.features.settings.data.interactor.setting_backup_restore;


import com.sourcemind.pfe.istock.core.annotations.Interactor;
import com.sourcemind.pfe.istock.core.mapper.Mapper;
import com.sourcemind.pfe.istock.features.settings.data.dto.SettingRequest;
import com.sourcemind.pfe.istock.features.settings.data.usecases_impl.SettingBackupUsecase;
import com.sourcemind.pfe.istock.features.settings.domain.entity.SettingBackUpRestore;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Optional.empty;
import static org.springframework.http.ResponseEntity.of;
import static org.springframework.http.ResponseEntity.ok;

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

@Interactor
@RequiredArgsConstructor
public class SettingBackupInteractor implements ISettingBackupInteractor, Mapper<SettingRequest, SettingBackUpRestore> {

    private final SettingBackupUsecase usecase;

    @Override
    public ResponseEntity<SettingRequest> get(String key) {
        Optional<SettingBackUpRestore> optional = this.usecase.get(key);
        return optional.map(setting -> ok(this.toRequest(setting))).orElse(of(empty()));
    }

    @Override
    public ResponseEntity<List<SettingRequest>> getAll() {
        var settings = this.usecase.all();
        var collection = settings.stream().map(this::toRequest).collect(Collectors.toList());
        return ok(collection);
    }

    @Override
    public ResponseEntity<Boolean> update(SettingRequest dto) {
        return ok(this.usecase.update(dto.getSettingKey(), dto.getSettingValue()));
    }

    @Override
    public ResponseEntity<Boolean> updateAll(List<SettingRequest> list) {
        var settings = list.stream().map(this::toModel).collect(Collectors.toList());
        return ok(this.usecase.updateMany(settings));
    }

    public SettingRequest toRequest(SettingBackUpRestore model) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(model, SettingRequest.class);
    }

    public SettingBackUpRestore toModel(SettingRequest request) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(request, SettingBackUpRestore.class);
    }
}