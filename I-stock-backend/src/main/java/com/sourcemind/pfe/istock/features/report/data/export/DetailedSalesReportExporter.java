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

import com.sourcemind.pfe.istock.core.constants.ReportConstant;
import com.sourcemind.pfe.istock.core.params.BiParam;
import com.sourcemind.pfe.istock.core.params.DataExporter;
import com.sourcemind.pfe.istock.core.params.DateRangeParam;
import com.sourcemind.pfe.istock.core.utils.ExportUtil;
import com.sourcemind.pfe.istock.features.authentication.domain.entity.User;
import com.sourcemind.pfe.istock.features.authentication.domain.usecase.IUserUsecase;
import com.sourcemind.pfe.istock.features.report.data.request.DetailReportMainParam;
import com.sourcemind.pfe.istock.features.sale.data.export.SaleExportCommon;
import com.sourcemind.pfe.istock.features.sale.data.export.SalesReportExporter;
import com.sourcemind.pfe.istock.features.sale.domain.entity.SaleTransaction;
import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.sourcemind.pfe.istock.core.utils.Util.formatAmount;
import static com.sourcemind.pfe.istock.features.sale.data.enums.SaleReportFileEnum.SALE_DETAILED_REPORT;
import static java.lang.String.valueOf;

@Component
@RequiredArgsConstructor
public class DetailedSalesReportExporter implements DataExporter<byte[], BiParam<List<SaleTransaction>, DateRangeParam>> {
    private final SaleExportCommon common;
    private final IUserUsecase userUsecase;
    private final SalesReportExporter salesReportExporter;


    @Override
    public byte[] export(BiParam<List<SaleTransaction>, DateRangeParam> param) {
        HashMap<String, Object> map = getMap(param);
        return ExportUtil.generatePDFBytes(
                map,
                SALE_DETAILED_REPORT.asInputStream(),
                new JRBeanCollectionDataSource(mainTransactionList(param.getLeft()))
        );
    }

    private HashMap<String, Object> getMap(BiParam<List<SaleTransaction>, DateRangeParam> param) {
        DateRangeParam dateRangeParam = param.getRight();
        HashMap<String, Object> map = this.common.toMap();
        map.put("reportTitle", getReportTitle(dateRangeParam));
        map.put("totalItemQty", valueOf(param.getLeft().stream().mapToInt(value -> value.getItems().size()).sum()));
        map.put("sumGrandTotalAmount", formatAmount(param.getLeft().stream().mapToDouble(value -> value.getAmount().getGrandTotal()).sum()));
        return map;
    }

    private List<DetailReportMainParam> mainTransactionList(List<SaleTransaction> list) {
        return list.stream().map(transaction -> {
            transaction.setCreatedBy(this.getUserFullName(transaction.getCreatedBy()));
            return DetailReportMainParam.fromTransaction(transaction);
        }).collect(Collectors.toList());
    }


    private String getReportTitle(DateRangeParam dateRange) {
        return String.format(
                "%s FROM %s - %s",
                ReportConstant.SALES_DETAILED_REPORT_TITLE,
                dateRange.getStartDate().toString(),
                dateRange.getEndDate().toString()
        );
    }

    private String getUserFullName(String username) {
        Optional<User> optionalUser = this.userUsecase.findByUsername(username);
        return optionalUser.map(User::getName).orElse(username);
    }

}
