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


package com.sourcemind.pfe.istock.features.report.data.interactor.implementation;

import com.sourcemind.pfe.istock.core.annotations.Interactor;
import com.sourcemind.pfe.istock.core.params.BiParam;
import com.sourcemind.pfe.istock.core.params.DateRangeParam;
import com.sourcemind.pfe.istock.features.report.data.export.DetailedSalesReportExporter;
import com.sourcemind.pfe.istock.features.report.data.export.SummarizedSalesReportExporter;
import com.sourcemind.pfe.istock.features.report.data.interactor.contract.IReportSaleInteractor;
import com.sourcemind.pfe.istock.features.report.data.request.SaleReportRequest;
import com.sourcemind.pfe.istock.features.sale.domain.entity.SaleTransaction;
import com.sourcemind.pfe.istock.features.sale.domain.usecase.SaleTransactionUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static com.sourcemind.pfe.istock.core.constants.ReportConstant.PDF_CONTENT_TYPE;
import static com.sourcemind.pfe.istock.core.constants.ReportConstant.REPORT_FILE_NAME;
import static com.sourcemind.pfe.istock.features.sale.data.request.specification.SaleTransactionSearchSpecification.salesReportSpecification;
import static org.springframework.http.ResponseEntity.ok;

@Interactor
@RequiredArgsConstructor
public class ReportSaleInteractor implements IReportSaleInteractor {

    private final SummarizedSalesReportExporter summarizedExporter;
    private final DetailedSalesReportExporter detailedSalesReportExporter;
    private final SaleTransactionUsecase usecase;

    @Override
    public ResponseEntity<byte[]> getDailyCollectionReport(SaleReportRequest request) {
        List<SaleTransaction> sales = this.usecase.findMany(salesReportSpecification(request));
        byte[] bytes = this.getBytesByReportType(request, sales);
        return ok()
                .header(HttpHeaders.CONTENT_TYPE, PDF_CONTENT_TYPE)
                .header(HttpHeaders.CONTENT_DISPOSITION, REPORT_FILE_NAME)
                .header(HttpHeaders.CONTENT_LENGTH, String.valueOf(bytes.length))
                .body(bytes);
    }

    private byte[] getBytesByReportType(SaleReportRequest request, List<SaleTransaction> sales) {
        BiParam<List<SaleTransaction>, DateRangeParam> param = new BiParam<>(
                sales,
                new DateRangeParam(request.getStartDate(), request.getEndDate())
        );

        switch (request.getReportType()) {
            case SUMMARIZED:
                return this.summarizedExporter.export(param);
            case DETAILED:
                return this.detailedSalesReportExporter.export(param);
            default:
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Report Type");
        }
    }
}
