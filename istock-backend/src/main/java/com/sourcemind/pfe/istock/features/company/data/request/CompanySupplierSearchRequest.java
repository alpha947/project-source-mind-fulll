
package com.sourcemind.pfe.istock.features.company.data.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sourcemind.pfe.istock.core.params.DateRangeParam;
import com.sourcemind.pfe.istock.features.product.data.request.ProductCategoryRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CompanySupplierSearchRequest {
	private String supplierFullName;
	private String supplierPhoneNumber;
	private String supplierEmail;
	private DateRangeParam dateRangeParam;
	private List<ProductCategoryRequest> categories;
	private LocalDate createdAt;
	private String registeredBy;
	private Boolean isActiveStatus;
}
