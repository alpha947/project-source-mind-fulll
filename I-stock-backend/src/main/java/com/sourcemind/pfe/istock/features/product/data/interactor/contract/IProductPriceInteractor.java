package com.sourcemind.pfe.istock.features.product.data.interactor.contract;

import com.sourcemind.pfe.istock.features.product.data.request.ProductDiscountRequest;
import com.sourcemind.pfe.istock.features.product.data.request.ProductPriceRequest;
import com.sourcemind.pfe.istock.features.product.domain.entity.ProductPrice;

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

public interface IProductPriceInteractor {
    ProductPrice save(ProductPriceRequest request);

    ProductPrice update(ProductPrice price);

    Boolean applyDiscount(ProductPrice price, ProductDiscountRequest request);

    ProductPrice update(ProductPriceRequest price);

}