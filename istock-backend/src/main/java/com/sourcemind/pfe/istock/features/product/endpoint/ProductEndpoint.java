package com.sourcemind.pfe.istock.features.product.endpoint;

import com.sourcemind.pfe.istock.core.params.PageSearchRequest;
import com.sourcemind.pfe.istock.core.params.PageSearchResult;
import com.sourcemind.pfe.istock.features.product.data.interactor.contract.IProductInteractor;
import com.sourcemind.pfe.istock.features.product.data.request.ProductDiscountRequest;
import com.sourcemind.pfe.istock.features.product.data.request.ProductRequest;
import com.sourcemind.pfe.istock.features.product.data.request.ProductSearchRequest;
import com.sourcemind.pfe.istock.features.stock.data.request.StockPriceRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

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
@RequestMapping(value = API_PREFIX + "/product")
@RequiredArgsConstructor
public class ProductEndpoint {

    private final IProductInteractor interactor;

    @PostMapping(value = "/create")
    public ResponseEntity<ProductRequest> create(@RequestBody ProductRequest request) {
        return this.interactor.save(request);
    }

    @PostMapping(value = "/search-request")
    public ResponseEntity<PageSearchResult<List<ProductRequest>>> searchProducts(
            @Valid @RequestBody PageSearchRequest<ProductSearchRequest> request
    ) {
        return this.interactor.search(request);
    }

    @PostMapping(value = "/set-price/{id}")
    public ResponseEntity<Optional<ProductRequest>> setPrice(
            @PathVariable Long id, @RequestBody StockPriceRequest price
    ) {
        return this.interactor.setPrice(id, price);
    }


    @PostMapping(value = "/set-discount")
    public ResponseEntity<Boolean> setDiscount(
            @RequestBody ProductDiscountRequest discountRequest
    ) {
        return this.interactor.setDiscount(discountRequest);
    }


    @PostMapping(value = "/set-quantity/{id}/{quantity}")
    public ResponseEntity<Optional<ProductRequest>> setQuantity(
            @PathVariable Long id,
            @PathVariable Integer quantity) {
        return this.interactor.setQuantity(id, quantity);
    }

    @GetMapping("search")
    public ResponseEntity<List<ProductRequest>> search(
            @RequestParam(value = "term") String term
    ) {
        return this.interactor.search(term);
    }

    @PostMapping(value = "/search-sales-products")
    public ResponseEntity<PageSearchResult<List<ProductRequest>>> searchSalesProducts(
            @Valid @RequestBody PageSearchRequest<ProductSearchRequest> request
    ) {
        return this.interactor.searchSalesProduct(request);
    }

    @PostMapping(value = "/import-file")
    public ResponseEntity<?> uploadBatchService(@RequestParam("file") MultipartFile file) throws IOException {
        return this.interactor.uploadTemplate(file);
    }

    @GetMapping("/download-template")
    @ResponseBody
    public ResponseEntity<Resource> downloadFile() throws IOException {
        return this.interactor.downloadTemplate();
    }
}