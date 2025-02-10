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

package com.sourcemind.pfe.istock.features.sale.domain.entity;

import com.sourcemind.pfe.istock.features.sale.domain.enums.SaleTransactionInstallmentType;
import lombok.*;

import javax.persistence.*;

import static com.sourcemind.pfe.istock.core.constants.Table.SALES_TRANSACTION_INSTALLMENT;

@Entity
@Table(name = SALES_TRANSACTION_INSTALLMENT)
@Getter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SaleTransactionInstallment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private SaleTransactionInstallmentType installmentType;

    @OneToOne(mappedBy = "installment", optional = false)
    private SaleTransaction transaction;

}
