package com.sourcemind.pfe.istock.features.company.domain.usecase;

import com.sourcemind.pfe.istock.features.company.domain.entity.CompanyExpenses;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Optional;


public interface ICompanyExpensesUsecase {

	Optional<CompanyExpenses> findById(Long id);

	CompanyExpenses save(CompanyExpenses model);

	Page<CompanyExpenses> findMany(Specification<CompanyExpenses> specification, Pageable pageable);

	List<CompanyExpenses> findMany(Specification<CompanyExpenses> specification);

}