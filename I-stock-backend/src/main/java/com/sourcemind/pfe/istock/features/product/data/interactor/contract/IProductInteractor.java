package com.sourcemind.pfe.istock.features.product.data.interactor.contract;

import com.sourcemind.pfe.istock.core.params.PageSearchRequest;
import com.sourcemind.pfe.istock.core.params.PageSearchResult;
import com.sourcemind.pfe.istock.features.product.data.request.ProductDiscountRequest;
import com.sourcemind.pfe.istock.features.product.data.request.ProductRequest;
import com.sourcemind.pfe.istock.features.product.data.request.ProductSearchRequest;
import com.sourcemind.pfe.istock.features.stock.data.request.StockPriceRequest;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

public interface IProductInteractor {
    ResponseEntity<ProductRequest> save(ProductRequest request);

    ResponseEntity<PageSearchResult<List<ProductRequest>>> search(PageSearchRequest<ProductSearchRequest> request);

    ResponseEntity<List<ProductRequest>> search(String term);

    ResponseEntity<Optional<ProductRequest>> setPrice(Long productId, StockPriceRequest priceRequest);

    ResponseEntity<Optional<ProductRequest>> setQuantity(Long id, Integer quantity);

    ResponseEntity<PageSearchResult<List<ProductRequest>>> searchSalesProduct(PageSearchRequest<ProductSearchRequest> request);

    ResponseEntity<Boolean> setDiscount(ProductDiscountRequest discountRequest);

    //    ResponseEntity<Map<String, Object>> uploadTemplate(MultipartFile file);
    ResponseEntity<?> uploadTemplate(MultipartFile file);

    ResponseEntity<Resource> downloadTemplate() throws IOException;


}