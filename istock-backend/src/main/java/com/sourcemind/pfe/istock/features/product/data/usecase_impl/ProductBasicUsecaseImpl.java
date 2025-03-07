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
import com.sourcemind.pfe.istock.features.product.data.repository.ProductBasicRepository;
import com.sourcemind.pfe.istock.features.product.domain.entity.ProductBasic;
import com.sourcemind.pfe.istock.features.product.domain.enums.ProductQuantityUpdateType;
import com.sourcemind.pfe.istock.features.product.domain.usecase.IProductBasicUsecase;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

import static com.sourcemind.pfe.istock.features.product.domain.enums.ProductQuantityUpdateType.DECREMENT;
import static com.sourcemind.pfe.istock.features.product.domain.enums.ProductQuantityUpdateType.INCREMENT;

@Usecase
@RequiredArgsConstructor
public class ProductBasicUsecaseImpl implements IProductBasicUsecase {
    private final ProductBasicRepository repository;

    public ProductBasic save(ProductBasic basic) {
        return this.repository.save(basic);
    }

    @Override
    public int updateProductQuantity(Long basicId, Integer quantity, ProductQuantityUpdateType updateType) {
        if (updateType == INCREMENT) {
            return this.repository.incrementQuantity(basicId, quantity);
        } else if (updateType == DECREMENT) {
            return this.repository.decrementQuantity(basicId, quantity);
        } else {
            return 0;
        }
    }

    @Override
    public Optional<ProductBasic> findByNameAndBrand(String name, String brand) {
        return this.repository.findByProductNameEqualsIgnoreCaseAndBrandNameEqualsIgnoreCase(name, brand);
    }

    @Override
    public Optional<ProductBasic> findByBarcode(String barcode) {
        return this.repository.findByBarcodeEqualsIgnoreCase(barcode);
    }

    @Override
    public Optional<ProductBasic> findBySku(String sku) {
        return this.repository.findBySkuEqualsIgnoreCase(sku);
    }
}
