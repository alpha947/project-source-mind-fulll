package com.sourcemind.pfe.istock.features.product.data.interactor.implementation;

import com.sourcemind.pfe.istock.core.annotations.Interactor;
import com.sourcemind.pfe.istock.core.mapper.Mapper;
import com.sourcemind.pfe.istock.features.product.data.interactor.contract.IProductVariantInteractor;
import com.sourcemind.pfe.istock.features.product.data.request.ProductVariantRequest;
import com.sourcemind.pfe.istock.features.product.domain.entity.ProductVariant;
import com.sourcemind.pfe.istock.features.product.domain.usecase.IProductVariantUsecase;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

import static com.sourcemind.pfe.istock.core.constants.Exception.RECORD_NOT_FOUND;
import static com.sourcemind.pfe.istock.core.constants.Exception.REQUIRED_ID;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

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
public class ProductVariantInteractor implements IProductVariantInteractor, Mapper<ProductVariantRequest, ProductVariant> {

    private final IProductVariantUsecase usecase;
    private final ModelMapper mapper;

    public ResponseEntity<ProductVariantRequest> save(ProductVariantRequest request) {
        var model = this.usecase.save(toModel(request));
        return ResponseEntity.ok().body(toRequest(model));
    }

    public ResponseEntity<List<ProductVariantRequest>> findAll() {
        var all = this.usecase.findAll();
        var requestList = all.stream().map(this::toRequest).collect(Collectors.toList());
        return ResponseEntity.ok().body(requestList);
    }

    public ResponseEntity<ProductVariantRequest> findOne(Long id) {
        var optional = this.usecase.findOne(id);
        return optional
                .map(model -> ResponseEntity.ok(toRequest(model)))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<ProductVariantRequest> update(ProductVariantRequest request) {
        this.throwIfRequestNotValid(request);
        return this.save(request);
    }

    private void throwIfRequestNotValid(ProductVariantRequest request) {
        if (ObjectUtils.isEmpty(request.getId())) {
            throw new ResponseStatusException(BAD_REQUEST, REQUIRED_ID);
        }

        if (!this.findOne(request.getId()).getStatusCode().is2xxSuccessful()) {
            throw new ResponseStatusException(NOT_FOUND, RECORD_NOT_FOUND);
        }
    }

    public ProductVariantRequest toRequest(ProductVariant model) {
        return mapper.map(model, ProductVariantRequest.class);
    }

    public ProductVariant toModel(ProductVariantRequest request) {
        return mapper.map(request, ProductVariant.class);
    }
}