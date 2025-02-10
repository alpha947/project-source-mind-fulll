
package com.sourcemind.pfe.istock.features.company.data.usecase_impl;

import com.sourcemind.pfe.istock.core.annotations.Usecase;
import com.sourcemind.pfe.istock.features.company.data.repository.CompanyEmployeeNokDetailRepository;
import com.sourcemind.pfe.istock.features.company.domain.entity.CompanyEmployeeNokDetail;
import com.sourcemind.pfe.istock.features.company.domain.usecase.ICompanyEmployeeNokDetailUsecase;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@Usecase
@RequiredArgsConstructor
public class CompanyEmployeeNokDetailUsecaseImpl implements ICompanyEmployeeNokDetailUsecase {
	private final CompanyEmployeeNokDetailRepository repository;

	@Override
	public CompanyEmployeeNokDetail save(CompanyEmployeeNokDetail detail) {
		return this.repository.save(detail);
	}

	@Override
	public Optional<CompanyEmployeeNokDetail> findOne(Long id) {
		return this.repository.findById(id);
	}
}
