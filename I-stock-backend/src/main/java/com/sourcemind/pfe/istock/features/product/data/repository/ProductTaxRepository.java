package com.sourcemind.pfe.istock.features.product.data.repository;

import com.sourcemind.pfe.istock.features.product.domain.entity.ProductTax;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
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
public interface ProductTaxRepository extends JpaRepository<ProductTax, Long> {
    Optional<ProductTax> findByTitleEqualsIgnoreCaseAndPercent(String title, Double percent);

    Optional<ProductTax> findByTitleEqualsIgnoreCase(String name);

    @Transactional
    @Modifying
    @Query(value = "update ProductTax c set c.isActiveStatus = :status where c.id = :id")
    int updateIsActiveStatus(@Param(value = "status") Boolean status, @Param(value = "id") Long id);
}
