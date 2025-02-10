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

package com.sourcemind.pfe.istock.features.sale.data.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sourcemind.pfe.istock.core.request.CommonRequest;
import com.sourcemind.pfe.istock.core.utils.Util;
import com.sourcemind.pfe.istock.features.company.data.request.CompanyCustomerRequest;
import com.sourcemind.pfe.istock.features.company.data.request.CompanyEmployeeRequest;
import com.sourcemind.pfe.istock.features.company.domain.entity.CompanyCustomer;
import com.sourcemind.pfe.istock.features.company.domain.entity.CompanyPaymentOption;
import com.sourcemind.pfe.istock.features.sale.domain.entity.SaleTransaction;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.time.LocalTime;
import java.util.List;

import static com.sourcemind.pfe.istock.core.constants.Global.SALES_TRANSACTION_ENDPOINT;
import static com.sourcemind.pfe.istock.core.utils.Util.parseToLocalDate;
import static java.lang.String.format;
import static org.springframework.util.ObjectUtils.isEmpty;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SaleTransactionRequest {
    private Long id;
    private String reference;
    private String serial;
    private String time;
    private String date;
    private CompanyCustomerRequest customer;
    private CompanyEmployeeRequest employee;
    private SaleTransactionAmountRequest amount;
    private SaleTransactionInstallmentRequest installment;
    private List<SaleTransactionItemRequest> items;
    private String other;
    private String receiptUrl;
    private CommonRequest paymentOption;


    public static SaleTransaction toModel(SaleTransactionRequest request) {
        SaleTransaction transaction = new SaleTransaction();
        transaction.setId(request.getId());
        transaction.setDate(!isEmpty(request.getDate()) ? parseToLocalDate(request.getDate()) : null);
        transaction.setTime(!isEmpty(request.getTime()) ? LocalTime.parse(request.getTime()) : null);
        transaction.setReference(request.getReference());
        transaction.setSerial(request.getSerial());

        /*todo:: set user making this transaction*/

        if (!isEmpty(request.getCustomer())) {
            transaction.setCustomer(new CompanyCustomer(request.getCustomer().getId()));
        } else {
            transaction.setCustomer(null);
        }

        if (!isEmpty(request.getPaymentOption()) && !isEmpty(request.getPaymentOption().getId())) {
            transaction.setPaymentOption(new CompanyPaymentOption(request.getPaymentOption().getId()));
        }

        transaction.setAmount(SaleTransactionAmountRequest.toModel(request.getAmount()));
        transaction.setInstallment(SaleTransactionInstallmentRequest.toModel(request.getInstallment()));
        transaction.setOther(request.getOther());

        return transaction;
    }

    public static SaleTransactionRequest toRequest(SaleTransaction transaction) {
        ModelMapper mapper = new ModelMapper();
        SaleTransactionRequest request = mapper.map(transaction, SaleTransactionRequest.class);
        request.setTime(Util.formatTime(transaction.getTime()));
        request.setDate(Util.formatDate(transaction.getDate()));
        request.setReceiptUrl(receiptUrl(transaction.getSerial()));
        return request;
    }

    public static String receiptUrl(String serial) {
        String serverUri = ServletUriComponentsBuilder.fromCurrentContextPath().toUriString();
        String base = serverUri + SALES_TRANSACTION_ENDPOINT;
        return format("%s/search-receipt?serial=%s", base, serial);
    }
}
