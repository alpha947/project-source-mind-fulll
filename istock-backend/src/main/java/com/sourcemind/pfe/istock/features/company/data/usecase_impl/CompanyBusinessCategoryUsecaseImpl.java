
package com.sourcemind.pfe.istock.features.company.data.usecase_impl;

import com.sourcemind.pfe.istock.core.annotations.Usecase;
import com.sourcemind.pfe.istock.features.company.data.repository.CompanyBusinessCategoryRepository;
import com.sourcemind.pfe.istock.features.company.domain.entity.CompanyBusinessCategory;
import com.sourcemind.pfe.istock.features.company.domain.usecase.ICompanyBusinessCategoryUsecase;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@Usecase
@RequiredArgsConstructor
public class CompanyBusinessCategoryUsecaseImpl implements ICompanyBusinessCategoryUsecase {
	private final CompanyBusinessCategoryRepository repository;

	@Override
	public List<CompanyBusinessCategory> getAll() {
		return this.repository.findAll();
	}

	@Override
	public Optional<CompanyBusinessCategory> getOne(Long id) {
		return this.repository.findById(id);
	}
}
