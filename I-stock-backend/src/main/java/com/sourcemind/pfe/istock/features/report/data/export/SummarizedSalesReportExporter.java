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

package com.sourcemind.pfe.istock.features.report.data.export;

import com.sourcemind.pfe.istock.core.params.BiParam;
import com.sourcemind.pfe.istock.core.params.DataExporter;
import com.sourcemind.pfe.istock.core.params.DateRangeParam;
import com.sourcemind.pfe.istock.features.sale.data.export.SalesReportExporter;
import com.sourcemind.pfe.istock.features.sale.domain.entity.SaleTransaction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.sourcemind.pfe.istock.core.constants.ReportConstant.SALES_SUMMARIZED_REPORT_TITLE;

@Component
@RequiredArgsConstructor
public class SummarizedSalesReportExporter implements DataExporter<byte[], BiParam<List<SaleTransaction>, DateRangeParam>> {
    private final SalesReportExporter salesReportExporter;


    @Override
    public byte[] export(BiParam<List<SaleTransaction>, DateRangeParam> param) {
        DateRangeParam right = param.getRight();
        
        salesReportExporter.reportTitle = String.format(
                "%s  FROM %s - %s", SALES_SUMMARIZED_REPORT_TITLE,
                right.getStartDate().toString(),
                right.getEndDate().toString()
        );
        byte[] export = salesReportExporter.export(param.getLeft());
        salesReportExporter.reportTitle = null;
        return export;
    }
}
