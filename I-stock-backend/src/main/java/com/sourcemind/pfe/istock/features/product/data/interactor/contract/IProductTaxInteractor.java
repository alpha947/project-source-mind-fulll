package com.sourcemind.pfe.istock.features.product.data.interactor.contract;

import com.sourcemind.pfe.istock.features.product.data.request.ProductTaxRequest;
import com.sourcemind.pfe.istock.features.product.domain.entity.ProductTax;
import org.springframework.http.ResponseEntity;

import java.util.List;
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

public interface IProductTaxInteractor {

	ResponseEntity<List<ProductTaxRequest>> findAll();

	ResponseEntity<Optional<ProductTaxRequest>> save(ProductTaxRequest request);

	ResponseEntity<Optional<Boolean>> remove(Long id);

	ResponseEntity<Optional<ProductTaxRequest>> find(Long id);

	ResponseEntity<Optional<ProductTaxRequest>> update(ProductTaxRequest request);

	ResponseEntity<Optional<Boolean>> toggleActiveStatus(Long id);

	List<ProductTax> mapRequestListToModelList(List<ProductTaxRequest> requests);
}
