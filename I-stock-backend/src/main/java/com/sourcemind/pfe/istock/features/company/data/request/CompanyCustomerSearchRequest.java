
package com.sourcemind.pfe.istock.features.company.data.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sourcemind.pfe.istock.core.params.DateRangeParam;
import com.sourcemind.pfe.istock.features.company.domain.enums.CustomerTagEnum;
import com.sourcemind.pfe.istock.features.product.data.request.ProductCategoryRequest;
import com.sourcemind.pfe.istock.features.product.data.request.ProductRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CompanyCustomerSearchRequest {
	private String customerFullName;
	private String customerPhoneNumber;
	private String customerEmail;
	private DateRangeParam dateRangeParam;
	private CustomerTagEnum customerTag;
	private ProductCategoryRequest productCategoryRequest;
	private ProductRequest productRequest;
	private String promotion;
	private String registeredBy;
	private Boolean isActiveStatus;
}
