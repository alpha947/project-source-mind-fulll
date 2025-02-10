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

package com.sourcemind.pfe.istock.features.sale.data.export;

import com.sourcemind.pfe.istock.core.constants.ReportConstant;
import com.sourcemind.pfe.istock.core.params.DataExporter;
import com.sourcemind.pfe.istock.core.utils.ExportUtil;
import com.sourcemind.pfe.istock.features.authentication.domain.entity.User;
import com.sourcemind.pfe.istock.features.authentication.domain.usecase.IUserUsecase;
import com.sourcemind.pfe.istock.features.sale.data.request.report.SaleTransactionDailyReportData;
import com.sourcemind.pfe.istock.features.sale.domain.entity.SaleTransaction;
import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.sourcemind.pfe.istock.core.utils.Util.formatAmount;
import static com.sourcemind.pfe.istock.features.sale.data.enums.SaleReportFileEnum.SALE_SHIFT_REPORT;
import static com.sourcemind.pfe.istock.features.sale.data.request.report.SaleTransactionDailyReportData.mapFromTransaction;
import static java.lang.String.valueOf;
import static org.apache.commons.lang3.ObjectUtils.isNotEmpty;

@Component
@RequiredArgsConstructor
public class SalesReportExporter implements DataExporter<byte[], List<SaleTransaction>> {
    private final SaleExportCommon common;
    private final IUserUsecase userUsecase;

    public String reportTitle = null;

    @Override
    public byte[] export(List<SaleTransaction> data) {
        HashMap<String, Object> map = getReportParamMap(data);
        return ExportUtil.generatePDFBytes(map, SALE_SHIFT_REPORT.asInputStream(), new JREmptyDataSource());
    }

    private HashMap<String, Object> getReportParamMap(List<SaleTransaction> data) {
        HashMap<String, Object> map = this.common.toMap();
        map.put("reportTitle", getReportTitle());
        map.put("transactionList", new JRBeanCollectionDataSource(mapFromTransactionList(data)));
        map.put("sumGrandTotalAmount", formatAmount(data.stream().mapToDouble(value -> value.getAmount().getGrandTotal()).sum()));
        map.put("totalQty", valueOf(data.stream().mapToInt(value -> value.getItems().size()).sum()));
        return map;
    }

    private List<SaleTransactionDailyReportData> mapFromTransactionList(List<SaleTransaction> data) {
        return data.stream().map(transaction -> {
                    transaction.setCreatedBy(this.getUserFullName(transaction.getCreatedBy()));
                    return mapFromTransaction(transaction);
                }
        ).collect(Collectors.toList());
    }

    private String getUserFullName(String username) {
        Optional<User> optionalUser = this.userUsecase.findByUsername(username);
        return optionalUser.map(User::getName).orElse(username);
    }

    private String getReportTitle() {
        if (isNotEmpty(this.reportTitle)) {
            return this.reportTitle;
        }
        return ReportConstant.SALES_REPORT_TITLE;
    }

}
