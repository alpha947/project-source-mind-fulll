
package com.sourcemind.pfe.istock.features.company.data.usecase_impl;

import com.sourcemind.pfe.istock.core.annotations.Usecase;
import com.sourcemind.pfe.istock.features.company.data.repository.CompanyEmployeePersonalDetailRepository;
import com.sourcemind.pfe.istock.features.company.domain.entity.CompanyEmployeePersonalDetail;
import com.sourcemind.pfe.istock.features.company.domain.usecase.ICompanyEmployeePersonalDetailUsecase;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@Usecase
@RequiredArgsConstructor
public class CompanyEmployeePersonalDetailUsecaseImpl implements ICompanyEmployeePersonalDetailUsecase {
	private final CompanyEmployeePersonalDetailRepository repository;

	@Override
	public CompanyEmployeePersonalDetail save(CompanyEmployeePersonalDetail detail) {
		return this.repository.save(detail);
	}

	@Override
	public Optional<CompanyEmployeePersonalDetail> findOne(Long id) {
		return this.repository.findById(id);
	}
}
