package com.sourcemind.pfe.istock.features.product.domain.usecase;

import com.sourcemind.pfe.istock.features.product.domain.entity.ProductTax;

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

public interface IProductTaxUsecase {
    List<ProductTax> findAll();

    Optional<ProductTax> save(ProductTax model);

    Optional<Boolean> remove(Long id);

    Optional<ProductTax> findOne(Long id);

    Optional<ProductTax> findOne(String name);

    Boolean toggleStatus(boolean status, Long id);
}
