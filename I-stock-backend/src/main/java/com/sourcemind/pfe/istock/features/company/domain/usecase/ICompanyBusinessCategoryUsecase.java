
package com.sourcemind.pfe.istock.features.company.domain.usecase;

import com.sourcemind.pfe.istock.features.company.domain.entity.CompanyBusinessCategory;

import java.util.List;
import java.util.Optional;

public interface ICompanyBusinessCategoryUsecase {
	List<CompanyBusinessCategory> getAll();

	Optional<CompanyBusinessCategory> getOne(Long id);

}
