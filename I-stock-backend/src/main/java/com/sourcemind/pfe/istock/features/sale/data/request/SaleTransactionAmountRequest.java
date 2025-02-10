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


package com.sourcemind.pfe.istock.features.sale.data.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sourcemind.pfe.istock.features.sale.domain.entity.SaleTransactionAmount;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SaleTransactionAmountRequest {
    private Long id;
    private Double grandTotal;
    private Double discountTotal;
    private Double taxTotal;
    private Double subTotal;

    public static SaleTransactionAmount toModel(SaleTransactionAmountRequest request) {

        SaleTransactionAmount amount = new SaleTransactionAmount();
        amount.setGrandTotal(request.getGrandTotal());
        amount.setDiscountTotal(request.getDiscountTotal());
        amount.setSubTotal(request.getSubTotal());
        amount.setTaxTotal(request.getTaxTotal());
        amount.setId(request.getId());
        return amount;

    }
}
