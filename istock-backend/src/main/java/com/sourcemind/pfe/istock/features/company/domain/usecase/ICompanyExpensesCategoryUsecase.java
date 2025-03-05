
package com.sourcemind.pfe.istock.features.company.domain.usecase;

import com.sourcemind.pfe.istock.features.company.domain.entity.CompanyExpensesCategory;

import java.util.List;
import java.util.Optional;

public interface ICompanyExpensesCategoryUsecase {

	CompanyExpensesCategory save(CompanyExpensesCategory category);

	List<CompanyExpensesCategory> findAll();

	Optional<CompanyExpensesCategory> findOne(Long id);
}
