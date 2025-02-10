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

import com.sourcemind.pfe.istock.features.product.domain.entity.Product;
import lombok.*;

import javax.persistence.*;

import static com.sourcemind.pfe.istock.core.constants.Table.SALES_TRANSACTION_ITEM;

@Entity
@Table(name = SALES_TRANSACTION_ITEM)
@Getter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SaleTransactionItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Product product;

    private Integer quantity;

    private Double price;

    private Double grandTotal;

    private Double discount;

    private Double tax;

    private Double subTotal;

    @ManyToOne(fetch = FetchType.LAZY)
    private SaleTransaction transaction;
}
