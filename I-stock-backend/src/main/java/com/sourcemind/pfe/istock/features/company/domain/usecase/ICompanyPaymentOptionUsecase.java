package com.sourcemind.pfe.istock.features.company.domain.usecase;

import com.sourcemind.pfe.istock.features.company.domain.entity.CompanyPaymentOption;

import java.util.List;
import java.util.Optional;

public interface ICompanyPaymentOptionUsecase {
	List<CompanyPaymentOption> findAll();

	Optional<CompanyPaymentOption> save(CompanyPaymentOption model);

	Boolean disable(Long id);

	Boolean enable(Long id);

	Optional<CompanyPaymentOption> findOne(Long id);

	Boolean toggleStatus(boolean status, Long id);
}
