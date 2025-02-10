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

package com.sourcemind.pfe.istock.features.product.data.usecase_impl;

import com.sourcemind.pfe.istock.core.annotations.Usecase;
import com.sourcemind.pfe.istock.features.product.data.repository.ProductDiscountDurationRepository;
import com.sourcemind.pfe.istock.features.product.data.repository.ProductPriceRepository;
import com.sourcemind.pfe.istock.features.product.domain.entity.ProductDiscountDuration;
import com.sourcemind.pfe.istock.features.product.domain.entity.ProductPrice;
import com.sourcemind.pfe.istock.features.product.domain.usecase.IProductPriceUsecase;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@Usecase
@RequiredArgsConstructor
public class ProductPriceUsecaseImpl implements IProductPriceUsecase {
    private final ProductPriceRepository repository;
    private final ProductDiscountDurationRepository discountDurationRepository;


    public ProductPrice save(ProductPrice price) {
        return this.repository.save(price);
    }

    @Override
    public Optional<ProductPrice> updateProductPrice(ProductPrice price) {
        return Optional.empty();
    }

    @Override
    public ProductDiscountDuration updateDiscountDuration(ProductDiscountDuration duration) {
        Optional<ProductDiscountDuration> optional = this.discountDurationRepository.findProductDiscountDurationByPriceId(duration.getPriceId());
        return optional.map(discount -> {
            duration.setId(discount.getId());
            return this.discountDurationRepository.save(duration);
        }).orElseGet(() -> this.discountDurationRepository.save(duration));
    }

}
