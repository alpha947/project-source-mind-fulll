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


package com.sourcemind.pfe.istock.features.report.data.request;

import com.sourcemind.pfe.istock.features.sale.domain.entity.SaleTransaction;
import com.sourcemind.pfe.istock.features.sale.domain.entity.SaleTransactionItem;
import lombok.Data;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.util.List;
import java.util.stream.Collectors;

import static com.sourcemind.pfe.istock.core.constants.ReportConstant.EMPTY;
import static com.sourcemind.pfe.istock.core.utils.Util.formatDate;
import static com.sourcemind.pfe.istock.core.utils.Util.formatTime;
import static java.lang.String.valueOf;
import static org.springframework.util.ObjectUtils.isEmpty;

@Data
public class DetailReportMainParam {
    private String rowNumber;
    private String rowStaff;
    private String rowCustomer;
    private String rowTotalQty;
    private String rowReceiptNumber;
    private String rowPaymentMethod;
    private String rowDate;
    private String rowTime;
    private Double rowSubTotal;
    private Double rowTotal;
    private JRBeanCollectionDataSource rowSubItems;

    public static DetailReportMainParam fromTransaction(SaleTransaction transaction) {
        DetailReportMainParam param = new DetailReportMainParam();
        param.setRowStaff(!isEmpty(transaction.getCreatedBy()) ? transaction.getCreatedBy().toUpperCase() : EMPTY);
        param.setRowCustomer(!isEmpty(transaction.getCustomer()) ? transaction.getCustomer().getFullName().toUpperCase() : EMPTY);
        param.setRowTotalQty(valueOf(transaction.getItems().stream().mapToInt(SaleTransactionItem::getQuantity).sum()));
        param.setRowReceiptNumber(transaction.getSerial().toUpperCase());
        param.setRowPaymentMethod(transaction.getPaymentOption().getTitle().toUpperCase());
        param.setRowDate(formatDate(transaction.getDate()).toUpperCase());
        param.setRowTime(formatTime(transaction.getTime()).toUpperCase());
        param.setRowSubTotal(transaction.getAmount().getSubTotal());
        param.setRowTotal(transaction.getAmount().getGrandTotal());
        param.setRowSubItems(new JRBeanCollectionDataSource(subTransactionList(transaction.getItems())));
        return param;
    }

    private static List<DetailReportSubParam> subTransactionList(List<SaleTransactionItem> list) {
        return list.stream().map(DetailReportSubParam::fromTransactionItem).collect(Collectors.toList());
    }
}
