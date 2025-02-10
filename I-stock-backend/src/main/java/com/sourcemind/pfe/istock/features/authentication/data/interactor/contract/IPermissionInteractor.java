package com.sourcemind.pfe.istock.features.authentication.data.interactor.contract;
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
import com.sourcemind.pfe.istock.features.authentication.data.request.PermissionGroupRequest;
import com.sourcemind.pfe.istock.features.authentication.data.request.PermissionRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IPermissionInteractor {
	ResponseEntity<List<PermissionRequest>> getAll();

	ResponseEntity<Optional<PermissionRequest>> getOne(Long id);

	ResponseEntity<List<PermissionGroupRequest>> getAllGroupedByModule();
}
