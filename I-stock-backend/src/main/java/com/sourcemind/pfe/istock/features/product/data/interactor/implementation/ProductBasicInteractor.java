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

package com.sourcemind.pfe.istock.features.product.data.interactor.implementation;

import com.sourcemind.pfe.istock.core.annotations.Interactor;
import com.sourcemind.pfe.istock.core.mapper.Mapper;
import com.sourcemind.pfe.istock.features.product.data.interactor.contract.IProductBasicInteractor;
import com.sourcemind.pfe.istock.features.product.data.interactor.contract.IProductTaxInteractor;
import com.sourcemind.pfe.istock.features.product.data.request.ProductBasicRequest;
import com.sourcemind.pfe.istock.features.product.domain.entity.ProductBasic;
import com.sourcemind.pfe.istock.features.product.domain.entity.ProductTax;
import com.sourcemind.pfe.istock.features.product.domain.usecase.IProductBasicUsecase;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.List;

@Interactor
@RequiredArgsConstructor
public class ProductBasicInteractor implements IProductBasicInteractor, Mapper<ProductBasicRequest, ProductBasic> {
    private final IProductBasicUsecase basicUsecase;
    private final IProductTaxInteractor taxInteractor;
    private final ModelMapper mapper;


    @Override
    public ProductBasic save(ProductBasicRequest request) {
        List<ProductTax> taxes = getTaxModels(request);
        ProductBasic model = this.toModel(request);
        model.setTaxes(taxes);
        return this.basicUsecase.save(model);
    }

    @Override
    public ProductBasic update(ProductBasic basic) {
        return this.basicUsecase.save(basic);
    }

    public ProductBasic update(ProductBasicRequest request) {
        ProductBasic model = this.toModel(request);
        return this.update(model);
    }

    private List<ProductTax> getTaxModels(ProductBasicRequest request) {
        List<ProductTax> taxList = taxInteractor.mapRequestListToModelList(request.getTaxes());
        request.setTaxes(null);
        return taxList;
    }

    @Override
    public ProductBasicRequest toRequest(ProductBasic model) {
        return this.mapper.map(model, ProductBasicRequest.class);
    }

    @Override
    public ProductBasic toModel(ProductBasicRequest request) {
        return this.mapper.map(request, ProductBasic.class);
    }
}
