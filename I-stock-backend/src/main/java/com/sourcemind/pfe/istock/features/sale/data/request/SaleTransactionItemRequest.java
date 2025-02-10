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
import com.sourcemind.pfe.istock.features.product.data.request.ProductRequest;
import com.sourcemind.pfe.istock.features.product.domain.entity.Product;
import com.sourcemind.pfe.istock.features.sale.domain.entity.SaleTransactionItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SaleTransactionItemRequest {
    private Long id;
    private ProductRequest product;
    private Integer quantity;
    private Double grandTotal;
    private Double discount;
    private Double tax;
    private Double subTotal;
    private Double price;

    public static SaleTransactionItem toModel(SaleTransactionItemRequest request) {
        SaleTransactionItem item = new SaleTransactionItem();
        item.setId(request.getId());
        item.setProduct(new Product(request.getProduct().getId()));
        item.setQuantity(request.getQuantity());
        item.setGrandTotal(request.getGrandTotal());
        item.setDiscount(request.getDiscount());
        item.setTax(request.getTax());
        item.setSubTotal(request.getSubTotal());
        item.setPrice(request.price);
        return item;

    }
}
