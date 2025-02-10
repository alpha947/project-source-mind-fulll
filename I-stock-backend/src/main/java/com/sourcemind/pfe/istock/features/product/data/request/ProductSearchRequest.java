package com.sourcemind.pfe.istock.features.product.data.request;

import com.sourcemind.pfe.istock.core.params.DateRangeParam;
import com.sourcemind.pfe.istock.core.params.MinMaxAmountParam;
import lombok.Data;

import java.util.List;

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

@Data
public class ProductSearchRequest {
    private Long id;
    private String productName;
    private String brandName;
    private String sku;
    private DateRangeParam dateRangeParam;
    private MinMaxAmountParam sellingPriceParam;
    private MinMaxAmountParam costPriceParam;
    private ProductCategoryRequest category;
    private List<ProductTaxRequest> taxes;
    private Boolean isService;
    private ProductStatusRequest status;
    private Boolean isActive;
    private String productOrBrandName;
    private List<ProductCategoryRequest> categories;
}