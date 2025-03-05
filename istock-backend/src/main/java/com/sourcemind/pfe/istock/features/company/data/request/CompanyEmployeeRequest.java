
package com.sourcemind.pfe.istock.features.company.data.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sourcemind.pfe.istock.features.authentication.data.request.UserRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CompanyEmployeeRequest {
    private Long id;
    private CompanyEmployeePersonalDetailRequest personalDetail;
    private CompanyEmployeeNokDetailRequest nokDetail;
    private UserRequest accountDetail;
    private String createdAt;
    private Boolean isActiveStatus;

}
