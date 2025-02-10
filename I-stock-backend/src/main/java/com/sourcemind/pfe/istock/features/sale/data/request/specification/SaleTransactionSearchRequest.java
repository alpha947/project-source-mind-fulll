/*
 * @Author: james.junior
 * @Date: 7/24/23 21:21
 *
 * @Project: stocky-api
 */

package com.sourcemind.pfe.istock.features.sale.data.request.specification;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sourcemind.pfe.istock.core.params.DateRangeParam;
import com.sourcemind.pfe.istock.features.authentication.data.request.UserRequest;
import com.sourcemind.pfe.istock.features.company.data.request.CompanyCustomerRequest;
import com.sourcemind.pfe.istock.features.sale.data.request.SaleTransactionInstallmentRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SaleTransactionSearchRequest {
    private Long id;
    private String reference;
    private String serial;
    private String time;
    private String date;
    private CompanyCustomerRequest customer;
    private UserRequest user;
    private SaleTransactionInstallmentRequest installment;
    private DateRangeParam dateRange;

}
