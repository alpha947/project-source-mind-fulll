

package com.sourcemind.pfe.istock.features.company.domain.entity;

import com.sourcemind.pfe.istock.core.base.BaseModel;
import com.sourcemind.pfe.istock.features.authentication.domain.entity.User;
import lombok.*;

import javax.persistence.*;

import static com.sourcemind.pfe.istock.core.constants.Table.COMPANY_EMPLOYEE;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = COMPANY_EMPLOYEE)
@Getter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompanyEmployee extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private CompanyEmployeePersonalDetail personalDetail;

    @OneToOne
    private CompanyEmployeeNokDetail nokDetail;

    @OneToOne
    private User accountDetail;

    public CompanyEmployee(Long id) {
        this.id = id;
    }
}
