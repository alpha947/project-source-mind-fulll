package com.sourcemind.pfe.istock.features.settings.data.repository;

import com.sourcemind.pfe.istock.features.settings.domain.entity.SettingBackUpRestore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

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

public interface SettingBackupRestoreRepository extends JpaRepository<SettingBackUpRestore, Long> {
    Optional<SettingBackUpRestore> findBySettingKey(String key);

    @Modifying
    @Query(value = "UPDATE SettingBackUpRestore s SET s.settingValue = :value where s.settingKey = :key")
    int updateByKey(String key, String value);
}