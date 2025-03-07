
package com.sourcemind.pfe.istock.features.company.domain.entity;

import com.sourcemind.pfe.istock.core.base.BaseModel;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

import static com.sourcemind.pfe.istock.core.constants.Table.COMPANY_EMPLOYEE_PERSONAL_DETAIL;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = COMPANY_EMPLOYEE_PERSONAL_DETAIL)
@Getter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompanyEmployeePersonalDetail extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "First name is required")
    @Column(nullable = false)
    private String employeeFirstName;
    private String employeeLastName;
    private String employeeEmail;
    private String employeePhone;
    private String employeeAddress;
    private LocalDate employeeDateOfBirth;

    public String getEmployeeFullName() {
        return String.format("%s %s", this.employeeFirstName, this.employeeLastName);
    }
}
