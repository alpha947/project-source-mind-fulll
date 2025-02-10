
package com.sourcemind.pfe.istock.features.company.domain.usecase;

import com.sourcemind.pfe.istock.features.company.domain.entity.CompanyEmployeePersonalDetail;

import java.util.Optional;

public interface ICompanyEmployeePersonalDetailUsecase {

	CompanyEmployeePersonalDetail save(CompanyEmployeePersonalDetail detail);

	Optional<CompanyEmployeePersonalDetail> findOne(Long id);


}
