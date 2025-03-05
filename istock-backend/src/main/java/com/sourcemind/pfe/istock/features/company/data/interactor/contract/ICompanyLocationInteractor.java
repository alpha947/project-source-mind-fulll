package com.sourcemind.pfe.istock.features.company.data.interactor.contract;
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
import com.sourcemind.pfe.istock.features.company.data.request.CompanyLocationRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ICompanyLocationInteractor {

	ResponseEntity<List<CompanyLocationRequest>> findAll();

	ResponseEntity<Optional<CompanyLocationRequest>> save(CompanyLocationRequest request);

	ResponseEntity<Optional<CompanyLocationRequest>> find(Long id);

	ResponseEntity<Optional<CompanyLocationRequest>> update(CompanyLocationRequest request);

	ResponseEntity<Optional<Boolean>> toggleActiveStatus(Long id);
}
