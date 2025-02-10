package com.sourcemind.pfe.istock.features.product.data.usecase_impl;

import com.sourcemind.pfe.istock.core.annotations.Usecase;
import com.sourcemind.pfe.istock.features.product.data.repository.ProductVariantRepository;
import com.sourcemind.pfe.istock.features.product.domain.entity.ProductVariant;
import com.sourcemind.pfe.istock.features.product.domain.usecase.IProductVariantUsecase;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

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

@Usecase
@RequiredArgsConstructor
public class ProductVariantUsecaseImpl implements IProductVariantUsecase {
    private final ProductVariantRepository repository;

    @Override
    public ProductVariant save(ProductVariant variant) {
        return this.repository.save(variant);
    }

    @Override
    public List<ProductVariant> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Optional<ProductVariant> findOne(Long id) {
        return this.repository.findById(id);
    }
}