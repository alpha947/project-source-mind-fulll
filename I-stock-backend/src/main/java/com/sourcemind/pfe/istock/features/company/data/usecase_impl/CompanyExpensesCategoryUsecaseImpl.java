
package com.sourcemind.pfe.istock.features.company.data.usecase_impl;

import com.sourcemind.pfe.istock.core.annotations.Usecase;
import com.sourcemind.pfe.istock.features.company.data.repository.CompanyExpensesCategoryRepository;
import com.sourcemind.pfe.istock.features.company.domain.entity.CompanyExpensesCategory;
import com.sourcemind.pfe.istock.features.company.domain.usecase.ICompanyExpensesCategoryUsecase;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@Usecase
@RequiredArgsConstructor
public class CompanyExpensesCategoryUsecaseImpl implements ICompanyExpensesCategoryUsecase {
	private final CompanyExpensesCategoryRepository repository;

	@Override
	public CompanyExpensesCategory save(CompanyExpensesCategory category) {
		return this.repository.save(category);
	}

	@Override
	public List<CompanyExpensesCategory> findAll() {
		return this.repository.findAll();
	}

	@Override
	public Optional<CompanyExpensesCategory> findOne(Long id) {
		return this.repository.findById(id);
	}
}
