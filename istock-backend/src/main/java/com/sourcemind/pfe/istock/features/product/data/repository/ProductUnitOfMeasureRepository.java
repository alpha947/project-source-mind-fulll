package com.sourcemind.pfe.istock.features.product.data.repository;

import com.sourcemind.pfe.istock.features.product.domain.entity.ProductUnitOfMeasure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

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

@Repository
public interface ProductUnitOfMeasureRepository extends JpaRepository<ProductUnitOfMeasure, Long> {
    Optional<ProductUnitOfMeasure> findByTitleEqualsIgnoreCaseAndUnitEqualsIgnoreCase(String type, String unit);

    Optional<ProductUnitOfMeasure> findByTitleEqualsIgnoreCase(String title);
}
