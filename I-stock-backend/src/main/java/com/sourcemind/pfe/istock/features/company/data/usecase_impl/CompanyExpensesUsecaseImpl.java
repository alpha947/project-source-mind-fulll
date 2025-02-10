package com.sourcemind.pfe.istock.features.company.data.usecase_impl;

import com.sourcemind.pfe.istock.core.annotations.Usecase;
import com.sourcemind.pfe.istock.features.company.data.repository.CompanyExpensesRepository;
import com.sourcemind.pfe.istock.features.company.domain.entity.CompanyExpenses;
import com.sourcemind.pfe.istock.features.company.domain.usecase.ICompanyExpensesUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Optional;

@Usecase
@RequiredArgsConstructor
public class CompanyExpensesUsecaseImpl implements ICompanyExpensesUsecase {

	private final CompanyExpensesRepository repository;

	@Override
	public Optional<CompanyExpenses> findById(Long id) {
		return this.repository.findById(id);
	}

	@Override
	public CompanyExpenses save(CompanyExpenses model) {
		return this.repository.save(model);
	}


	@Override
	public Page<CompanyExpenses> findMany(Specification<CompanyExpenses> specification, Pageable pageable) {
		return this.repository.findAll(specification, pageable);
	}

	@Override
	public List<CompanyExpenses> findMany(Specification<CompanyExpenses> specification) {
		return this.repository.findAll(specification);
	}
}