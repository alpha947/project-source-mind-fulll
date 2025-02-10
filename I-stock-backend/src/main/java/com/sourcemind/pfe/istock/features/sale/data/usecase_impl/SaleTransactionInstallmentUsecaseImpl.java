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
import com.sourcemind.pfe.istock.features.sale.data.repository.SaleTransactionInstallmentRepository;
import com.sourcemind.pfe.istock.features.sale.domain.entity.SaleTransaction;
import com.sourcemind.pfe.istock.features.sale.domain.entity.SaleTransactionInstallment;
import com.sourcemind.pfe.istock.features.sale.domain.usecase.SaleTransactionInstallmentUsecase;
import lombok.RequiredArgsConstructor;


@Usecase
@RequiredArgsConstructor
public class SaleTransactionInstallmentUsecaseImpl implements SaleTransactionInstallmentUsecase {

    private final SaleTransactionInstallmentRepository repository;


    @Override
    public SaleTransactionInstallment save(SaleTransactionInstallment installment) {
        return this.repository.save(installment);
    }

    @Override
    public void saveAndSet(SaleTransaction transaction) {
        SaleTransactionInstallment savedInstallment = this.save(transaction.getInstallment());
        transaction.setInstallment(savedInstallment);
    }
}
