/*
 * @Author: james.junior
 * @Date: 6/1/23 19:48
 *
 * @Project: stocky-api
 */

package com.sourcemind.pfe.istock.features.product.data.interactor.implementation;

import com.sourcemind.pfe.istock.core.annotations.Interactor;
import com.sourcemind.pfe.istock.core.mapper.Mapper;
import com.sourcemind.pfe.istock.features.product.data.interactor.contract.IProductPriceInteractor;
import com.sourcemind.pfe.istock.features.product.data.request.ProductDiscountRequest;
import com.sourcemind.pfe.istock.features.product.data.request.ProductPriceRequest;
import com.sourcemind.pfe.istock.features.product.domain.entity.ProductDiscountDuration;
import com.sourcemind.pfe.istock.features.product.domain.entity.ProductPrice;
import com.sourcemind.pfe.istock.features.product.domain.usecase.IProductPriceUsecase;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;

import static com.sourcemind.pfe.istock.core.constants.Exception.VALIDATION_ERROR;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.util.ObjectUtils.isEmpty;

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

@Interactor
@RequiredArgsConstructor
public class ProductPriceInteractor implements IProductPriceInteractor, Mapper<ProductPriceRequest, ProductPrice> {
    private final IProductPriceUsecase priceUsecase;
    private final ModelMapper mapper;


    @Override
    public ProductPrice save(ProductPriceRequest request) {
        ProductPrice model = this.toModel(request);
        return this.priceUsecase.save(model);
    }

    @Override
    public ProductPrice update(ProductPrice price) {
        return this.priceUsecase.save(price);
    }


    @Override
    public Boolean applyDiscount(ProductPrice price, ProductDiscountRequest request) {
        this.throwIfDiscountRequestNotValid(price, request);

        LocalDate start = LocalDate.parse(request.getStart());
        LocalDate end = LocalDate.parse(request.getEnd());
        price.setDiscount(request.getDiscount());
        this.update(price);

        ProductDiscountDuration duration = new ProductDiscountDuration(price.getId(), start, end);
        ProductDiscountDuration savedDuration = this.priceUsecase.updateDiscountDuration(duration);
        return savedDuration.getId() != null;
    }

    private void throwIfDiscountRequestNotValid(ProductPrice price, ProductDiscountRequest request) {
        if (isEmpty(price) || isEmpty(price.getId())) {
            throw new ResponseStatusException(BAD_REQUEST, String.format("%s :(%s) is missing", VALIDATION_ERROR, "PRODUCT PRICE"));
        }

        if (isEmpty(request) || isEmpty(request.getStart())) {
            throw new ResponseStatusException(BAD_REQUEST, String.format("%s :(%s) is missing", VALIDATION_ERROR, "STAR DATE"));
        }


        if (isEmpty(request) || isEmpty(request.getEnd())) {
            throw new ResponseStatusException(BAD_REQUEST, String.format("%s :(%s) is missing", VALIDATION_ERROR, "END DATE"));
        }


        if (isEmpty(request) || request.getDiscount() == null) {
            throw new ResponseStatusException(BAD_REQUEST, String.format("%s :(%s) is missing", VALIDATION_ERROR, "DISCOUNT AMOUNT"));
        }
    }

    @Override
    public ProductPrice update(ProductPriceRequest price) {
        ProductPrice model = this.toModel(price);
        return this.update(model);
    }

    @Override
    public ProductPriceRequest toRequest(ProductPrice model) {
        return this.mapper.map(model, ProductPriceRequest.class);
    }

    @Override
    public ProductPrice toModel(ProductPriceRequest request) {
        return this.mapper.map(request, ProductPrice.class);
    }
}
