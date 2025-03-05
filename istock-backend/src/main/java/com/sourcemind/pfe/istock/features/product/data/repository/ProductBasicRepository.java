package com.sourcemind.pfe.istock.features.product.data.repository;
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

import com.sourcemind.pfe.istock.features.product.domain.entity.ProductBasic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface ProductBasicRepository extends JpaRepository<ProductBasic, Long> {
    @Query(value = "update ProductBasic  p set p.quantity = p.quantity + :quantity where p.id = :id")
    @Modifying
    @Transactional
    int incrementQuantity(@Param(value = "id") Long id, @Param(value = "quantity") Integer quantity);


    @Query(value = "update ProductBasic  p set p.quantity = p.quantity - :quantity where p.id = :id")
    @Modifying
    @Transactional
    int decrementQuantity(@Param(value = "id") Long id, @Param(value = "quantity") Integer quantity);

    Optional<ProductBasic> findByProductNameEqualsIgnoreCaseAndBrandNameEqualsIgnoreCase(String productName, String brandName);

    Optional<ProductBasic> findByBarcodeEqualsIgnoreCase(String barcode);

    Optional<ProductBasic> findBySkuEqualsIgnoreCase(String sku);

}
