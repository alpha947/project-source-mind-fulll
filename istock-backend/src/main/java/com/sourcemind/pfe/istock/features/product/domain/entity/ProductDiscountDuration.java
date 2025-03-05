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

package com.sourcemind.pfe.istock.features.product.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

import static com.sourcemind.pfe.istock.core.constants.Table.PRODUCT_DISCOUNT;


@Entity
@Table(name = PRODUCT_DISCOUNT)
@Getter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductDiscountDuration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long priceId;
    private LocalDate startDate;
    private LocalDate endDate;


    public ProductDiscountDuration(Long priceId, LocalDate startDate, LocalDate endDate) {
        this.priceId = priceId;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
