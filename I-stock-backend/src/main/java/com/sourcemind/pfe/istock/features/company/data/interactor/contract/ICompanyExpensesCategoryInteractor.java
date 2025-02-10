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

package com.sourcemind.pfe.istock.features.company.data.interactor.contract;

import com.sourcemind.pfe.istock.features.company.data.request.CompanyExpensesCategoryRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ICompanyExpensesCategoryInteractor {

	ResponseEntity<CompanyExpensesCategoryRequest> save(CompanyExpensesCategoryRequest category);

	ResponseEntity<List<CompanyExpensesCategoryRequest>> findAll();

	ResponseEntity<Optional<CompanyExpensesCategoryRequest>> findOne(Long id);

	ResponseEntity<Optional<CompanyExpensesCategoryRequest>> update(CompanyExpensesCategoryRequest request);
}
