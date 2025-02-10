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

package com.sourcemind.pfe.istock.features.sale.data.interactor.contract;

import com.sourcemind.pfe.istock.core.params.PageSearchRequest;
import com.sourcemind.pfe.istock.core.params.PageSearchResult;
import com.sourcemind.pfe.istock.features.sale.data.request.SaleTransactionRequest;
import com.sourcemind.pfe.istock.features.sale.data.request.specification.SaleTransactionSearchRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;


public interface ISaleTransactionInteractor {

    ResponseEntity<SaleTransactionRequest> save(SaleTransactionRequest request);

    ResponseEntity<PageSearchResult<List<SaleTransactionRequest>>> findMany(PageSearchRequest<SaleTransactionSearchRequest> request);

    ResponseEntity<List<SaleTransactionRequest>> findMany(SaleTransactionSearchRequest request);

    ResponseEntity<Optional<SaleTransactionRequest>> findOne(Long id);

    Optional<byte[]> findTransactionReceipt(String reference, String serial);
    
    ResponseEntity<byte[]> searchReceiptBySerial(String serial);

    ResponseEntity<byte[]> searchSaleTransactionReport(SaleTransactionSearchRequest request);
}
