
package com.sourcemind.pfe.istock.features.company.domain.usecase;

import com.sourcemind.pfe.istock.features.company.domain.entity.CompanyEmployeeNokDetail;

import java.util.Optional;

public interface ICompanyEmployeeNokDetailUsecase {

	CompanyEmployeeNokDetail save(CompanyEmployeeNokDetail detail);

	Optional<CompanyEmployeeNokDetail> findOne(Long id);

}
