
package com.sourcemind.pfe.istock.features.company.domain.entity;

import com.sourcemind.pfe.istock.core.base.BaseModel;
import com.sourcemind.pfe.istock.features.company.domain.enums.CompanyLocationType;
import lombok.*;

import javax.persistence.*;

import static com.sourcemind.pfe.istock.core.constants.Table.COMPANY_LOCATION;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = COMPANY_LOCATION)
@Getter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompanyLocation extends BaseModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true, nullable = false)
	private String title;
	private String description;
	private CompanyLocationType type;
}
