
package com.sourcemind.pfe.istock.features.company.data.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sourcemind.pfe.istock.core.params.DateRangeParam;
import com.sourcemind.pfe.istock.features.authentication.data.request.RoleRequest;
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
public class CompanyEmployeeSearchRequest {
	private String employeeFullName;
	private String employeePhoneNumber;
	private String employeeEmail;
	private DateRangeParam dateRangeParam;
	private List<RoleRequest> roles;
	private LocalDate expirationDate;
	private LocalDate createdAt;
	private String registeredBy;
	private Boolean isActiveStatus;
}
