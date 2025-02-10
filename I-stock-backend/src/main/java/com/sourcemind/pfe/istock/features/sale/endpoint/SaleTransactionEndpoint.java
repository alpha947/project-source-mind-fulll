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

package com.sourcemind.pfe.istock.features.sale.endpoint;

import com.sourcemind.pfe.istock.features.sale.data.interactor.contract.ISaleTransactionInteractor;
import com.sourcemind.pfe.istock.features.sale.data.request.SaleTransactionRequest;
import com.sourcemind.pfe.istock.features.sale.data.request.specification.SaleTransactionSearchRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.sourcemind.pfe.istock.core.constants.Global.SALES_TRANSACTION_ENDPOINT;

@RestController
@RequestMapping(value = SALES_TRANSACTION_ENDPOINT)
@RequiredArgsConstructor
public class SaleTransactionEndpoint {

    private final ISaleTransactionInteractor interactor;

    @PostMapping("/create")
    public ResponseEntity<SaleTransactionRequest> saveTransaction(@RequestBody SaleTransactionRequest transaction) {
        return this.interactor.save(transaction);
    }

    @GetMapping("/search-receipt")
    public ResponseEntity<byte[]> searchReceiptBySerial(
            @RequestParam(value = "serial") String serial
    ) {
        return this.interactor.searchReceiptBySerial(serial);
    }

    @PostMapping(value = "/search-report")
    public ResponseEntity<byte[]> searchTransactionReport(@RequestBody SaleTransactionSearchRequest request) {
        return this.interactor.searchSaleTransactionReport(request);
    }

}
