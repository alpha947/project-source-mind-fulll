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


package com.sourcemind.pfe.istock.features.report.data.request;

import com.sourcemind.pfe.istock.features.sale.domain.entity.SaleTransactionItem;
import lombok.Data;

@Data
public class DetailReportSubParam {
    private String itemName;
    private String itemQty;
    private Double itemSubTotal;
    private Double itemTotal;
    private Double itemPrice;

    public static DetailReportSubParam fromTransactionItem(SaleTransactionItem saleItem) {
        DetailReportSubParam param = new DetailReportSubParam();
        param.setItemName(saleItem.getProduct().getBasic().title());
        param.setItemQty(saleItem.getQuantity().toString());
        param.setItemSubTotal(saleItem.getSubTotal());
        param.setItemTotal(saleItem.getGrandTotal());
        param.setItemPrice(saleItem.getPrice());
        return param;
    }
}
