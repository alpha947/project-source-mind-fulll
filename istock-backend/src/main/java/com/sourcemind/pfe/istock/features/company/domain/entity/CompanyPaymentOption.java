
package com.sourcemind.pfe.istock.features.company.domain.entity;

import com.sourcemind.pfe.istock.core.base.BaseModel;
import lombok.*;

import javax.persistence.*;

import static com.sourcemind.pfe.istock.core.constants.Table.COMPANY_PAYMENT_OPTION;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = COMPANY_PAYMENT_OPTION)
@Getter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompanyPaymentOption extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String title;
    private String description;

    public CompanyPaymentOption(Long id) {
        this.id = id;
    }
}
