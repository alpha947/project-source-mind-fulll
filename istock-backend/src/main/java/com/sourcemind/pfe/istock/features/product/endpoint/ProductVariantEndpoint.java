package com.sourcemind.pfe.istock.features.product.endpoint;

import com.sourcemind.pfe.istock.features.product.data.interactor.contract.IProductVariantInteractor;
import com.sourcemind.pfe.istock.features.product.data.request.ProductVariantRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.sourcemind.pfe.istock.core.constants.Global.API_PREFIX;

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

@RestController
@RequestMapping(value = API_PREFIX + "/product-variant")
@RequiredArgsConstructor
public class ProductVariantEndpoint {

    private final IProductVariantInteractor interactor;

    @GetMapping("/{id}")
    public ResponseEntity<ProductVariantRequest> findOne(@PathVariable Long id) {
        return this.interactor.findOne(id);
    }

    @PostMapping
    public ResponseEntity<ProductVariantRequest> save(@RequestBody @Valid ProductVariantRequest request) {
        return this.interactor.save(request);
    }

    @GetMapping
    public ResponseEntity<List<ProductVariantRequest>> findAll() {
        return this.interactor.findAll();
    }

    @PutMapping
    public ResponseEntity<ProductVariantRequest> update(@RequestBody @Valid ProductVariantRequest request) {
        return this.interactor.update(request);
    }


}