
package com.sourcemind.pfe.istock.features.company.domain.entity;

import com.sourcemind.pfe.istock.core.base.BaseModel;
import com.sourcemind.pfe.istock.features.product.domain.entity.ProductCategory;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

import static com.sourcemind.pfe.istock.core.constants.Table.COMPANY_SUPPLIER;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = COMPANY_SUPPLIER)
@Getter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompanySupplier extends BaseModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String supplierBusinessName;
	private String supplierFirstName;
	private String supplierLastName;
	private String supplierEmailAddress;
	private String supplierPhone;
	private String supplierOfficeAddress;

	@OneToMany
	@JoinTable
	private Set<ProductCategory> categories;

	public CompanySupplier(Long id) {
		this.id = id;
	}
}
