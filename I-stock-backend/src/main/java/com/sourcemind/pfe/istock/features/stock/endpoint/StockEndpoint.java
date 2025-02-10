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


package com.sourcemind.pfe.istock.features.stock.endpoint;

import com.sourcemind.pfe.istock.core.params.PageSearchRequest;
import com.sourcemind.pfe.istock.core.params.PageSearchResult;
import com.sourcemind.pfe.istock.features.stock.data.interactor.contract.IStockInteractor;
import com.sourcemind.pfe.istock.features.stock.data.request.StockCounterRequest;
import com.sourcemind.pfe.istock.features.stock.data.request.StockCounterResponse;
import com.sourcemind.pfe.istock.features.stock.data.request.StockRequest;
import com.sourcemind.pfe.istock.features.stock.data.request.StockSearchRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.sourcemind.pfe.istock.core.constants.Global.API_PREFIX;


@RestController
@RequestMapping(value = API_PREFIX + "/stock")
@RequiredArgsConstructor
public class StockEndpoint {

    private final IStockInteractor interactor;

    @PostMapping(value = "/create")
    public ResponseEntity<StockRequest> create(@RequestBody StockRequest request) {
        return this.interactor.save(request);
    }

    @PostMapping(value = "/search-request")
    public ResponseEntity<PageSearchResult<List<StockRequest>>> searchProducts(
            @Valid @RequestBody PageSearchRequest<StockSearchRequest> request
    ) {
        return this.interactor.search(request);
    }

    @GetMapping("search")
    public ResponseEntity<List<StockRequest>> search(
            @RequestParam(value = "term") String term
    ) {
        return this.interactor.search(term);
    }

    @PostMapping(value = "/count-stock")
    public ResponseEntity<PageSearchResult<StockCounterResponse>> countStock(@RequestBody StockCounterRequest request) {
        return this.interactor.countStock(request);
    }
}
