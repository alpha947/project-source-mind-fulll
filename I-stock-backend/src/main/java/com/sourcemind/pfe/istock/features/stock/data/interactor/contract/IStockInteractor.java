/**
 * ==========================================================
 * Projet de fin d'études - SourceMind
 *
 * Développé par l'équipe Groupe 4 :
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

package com.sourcemind.pfe.istock.features.stock.data.interactor.contract;

import com.sourcemind.pfe.istock.core.mapper.Mapper;
import com.sourcemind.pfe.istock.core.params.PageSearchRequest;
import com.sourcemind.pfe.istock.core.params.PageSearchResult;
import com.sourcemind.pfe.istock.features.stock.data.request.StockCounterRequest;
import com.sourcemind.pfe.istock.features.stock.data.request.StockCounterResponse;
import com.sourcemind.pfe.istock.features.stock.data.request.StockRequest;
import com.sourcemind.pfe.istock.features.stock.data.request.StockSearchRequest;
import com.sourcemind.pfe.istock.features.stock.domain.entity.Stock;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IStockInteractor extends Mapper<StockRequest, Stock> {
    ResponseEntity<StockRequest> save(StockRequest request);

    ResponseEntity<PageSearchResult<List<StockRequest>>> search(PageSearchRequest<StockSearchRequest> request);

    ResponseEntity<List<StockRequest>> search(String term);

    ResponseEntity<PageSearchResult<StockCounterResponse>> countStock(StockCounterRequest request);
}

