package com.sourcemind.pfe.istock.features.sale.domain.usecase;
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

import com.sourcemind.pfe.istock.features.sale.domain.entity.SaleTransaction;
import com.sourcemind.pfe.istock.features.sale.domain.entity.SaleTransactionItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Optional;

public interface SaleTransactionUsecase {

    SaleTransaction save(SaleTransaction saleTransaction, List<SaleTransactionItem> transactionItems);

    Page<SaleTransaction> findMany(Specification<SaleTransaction> specification, Pageable pageable);

    List<SaleTransaction> findMany(Specification<SaleTransaction> specification);

    Optional<SaleTransaction> findOne(Long id);


    Optional<SaleTransaction> findOne(String reference, String token);

    Optional<SaleTransaction> findOne(String serial);
}
