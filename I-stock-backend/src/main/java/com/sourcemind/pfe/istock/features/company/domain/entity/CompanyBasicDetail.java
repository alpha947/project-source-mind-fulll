
package com.sourcemind.pfe.istock.features.company.domain.entity;

import com.sourcemind.pfe.istock.core.base.BaseModel;
import lombok.*;

import javax.persistence.*;

import static com.sourcemind.pfe.istock.core.constants.Table.COMPANY_BASIC_DETAILS;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = COMPANY_BASIC_DETAILS)
@Getter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompanyBasicDetail extends BaseModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true, nullable = false)
	private String setupKey;
	private String setupValue;

	public CompanyBasicDetail(String setupKey, String setupValue) {
		this.setupKey = setupKey;
		this.setupValue = setupValue;
	}
}
