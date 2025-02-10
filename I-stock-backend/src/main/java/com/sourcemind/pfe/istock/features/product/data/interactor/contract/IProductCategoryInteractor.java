package com.sourcemind.pfe.istock.features.product.data.interactor.contract;

import com.sourcemind.pfe.istock.features.product.data.request.ProductCategoryRequest;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

public interface IProductCategoryInteractor {

    ResponseEntity<ProductCategoryRequest> find(Long id);

    ResponseEntity<List<ProductCategoryRequest>> findMany();

    ResponseEntity<Optional<ProductCategoryRequest>> save(ProductCategoryRequest request);

    ResponseEntity<Optional<ProductCategoryRequest>> update(ProductCategoryRequest request);

    ResponseEntity<Optional<Boolean>> remove(Long id);

    ResponseEntity<List<ProductCategoryRequest>> search(String term);

    ResponseEntity<Optional<Boolean>> toggleActiveStatus(Long id);

    ResponseEntity<Resource> downloadTemplate() throws IOException;

    ResponseEntity<?> uploadTemplate(MultipartFile file);
}
