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


package com.sourcemind.pfe.istock.features.sale.data.usecase_impl;

import com.sourcemind.pfe.istock.core.annotations.Usecase;
import com.sourcemind.pfe.istock.features.sale.data.repository.SaleTransactionAmountRepository;
import com.sourcemind.pfe.istock.features.sale.domain.entity.SaleTransaction;
import com.sourcemind.pfe.istock.features.sale.domain.entity.SaleTransactionAmount;
import com.sourcemind.pfe.istock.features.sale.domain.usecase.SaleTransactionAmountUsecase;
import lombok.RequiredArgsConstructor;

@Usecase
@RequiredArgsConstructor
public class SaleTransactionAmountUsecaseImpl implements SaleTransactionAmountUsecase {
    private final SaleTransactionAmountRepository repository;


    @Override
    public SaleTransactionAmount save(SaleTransactionAmount amount) {
        return this.repository.save(amount);
    }

    @Override
    public void saveAndSet(SaleTransaction transaction) {
        SaleTransactionAmount save = this.save(transaction.getAmount());
        transaction.setAmount(save);
    }
}
