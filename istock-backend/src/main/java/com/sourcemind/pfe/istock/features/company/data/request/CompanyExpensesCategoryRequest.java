
package com.sourcemind.pfe.istock.features.company.data.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CompanyExpensesCategoryRequest {
	private Long id;
	private String title;
	private String description;
	private Boolean isActiveStatus;
}
