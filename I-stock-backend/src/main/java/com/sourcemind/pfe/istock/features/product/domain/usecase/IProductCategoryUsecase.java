package com.sourcemind.pfe.istock.features.product.domain.usecase;

import com.sourcemind.pfe.istock.core.params.FileHandler;
import com.sourcemind.pfe.istock.features.product.domain.entity.ProductCategory;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
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

public interface IProductCategoryUsecase extends FileHandler<Map<String, String>, MultipartFile> {
    Optional<ProductCategory> findOne(Long id);

    Optional<ProductCategory> findOne(String name);

    List<ProductCategory> findAll();

    Optional<ProductCategory> save(ProductCategory category);

    Optional<Boolean> remove(Long id);

    List<ProductCategory> search(String term);

    Boolean toggleStatus(boolean b, Long id);


}
