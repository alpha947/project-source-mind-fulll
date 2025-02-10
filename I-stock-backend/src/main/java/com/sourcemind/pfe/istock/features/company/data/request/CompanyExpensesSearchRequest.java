package com.sourcemind.pfe.istock.features.company.data.request;

import com.sourcemind.pfe.istock.core.params.DateRangeParam;
import com.sourcemind.pfe.istock.core.params.MinMaxAmountParam;
import lombok.Data;


@Data
public class CompanyExpensesSearchRequest {
	private Long id;
	private CompanyExpensesCategoryRequest category;
	private String registeredBy;
	private String approvedBy;
	private MinMaxAmountParam amountRange;
	private DateRangeParam dateRangeParam;
	private Boolean isActiveStatus;

}