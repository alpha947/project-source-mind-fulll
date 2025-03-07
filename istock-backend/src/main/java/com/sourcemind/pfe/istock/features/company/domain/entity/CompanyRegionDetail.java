
package com.sourcemind.pfe.istock.features.company.domain.entity;

import com.sourcemind.pfe.istock.core.base.BaseModel;
import lombok.*;

import javax.persistence.*;

import static com.sourcemind.pfe.istock.core.constants.Table.COMPANY_REGION_DETAILS;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = COMPANY_REGION_DETAILS)
@Getter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompanyRegionDetail extends BaseModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true, nullable = false)
	private String setupKey;
	private String setupValue;


	public CompanyRegionDetail(String setupKey, String setupValue) {
		this.setSetupKey(setupKey);
		this.setSetupValue(setupValue);
	}

}
