package com.sourcemind.pfe.istock.features.company.data.interactor.implementation;

import com.sourcemind.pfe.istock.core.annotations.Interactor;
import com.sourcemind.pfe.istock.core.mapper.Mapper;
import com.sourcemind.pfe.istock.core.params.PageSearchRequest;
import com.sourcemind.pfe.istock.core.params.PageSearchResult;
import com.sourcemind.pfe.istock.features.company.data.interactor.contract.ICompanyExpensesInteractor;
import com.sourcemind.pfe.istock.features.company.data.request.CompanyExpensesRequest;
import com.sourcemind.pfe.istock.features.company.data.request.CompanyExpensesSearchRequest;
import com.sourcemind.pfe.istock.features.company.domain.entity.CompanyExpenses;
import com.sourcemind.pfe.istock.features.company.domain.usecase.ICompanyExpensesUsecase;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

import static com.sourcemind.pfe.istock.core.params.PageParam.toPageSearchResult;
import static com.sourcemind.pfe.istock.features.company.data.request.specification.CompanyExpensesSearchSpecification.companyExpensesSpecification;
import static org.springframework.http.ResponseEntity.ok;


@Interactor
@RequiredArgsConstructor
public class CompanyExpensesInteractorImpl implements ICompanyExpensesInteractor, Mapper<CompanyExpensesRequest, CompanyExpenses> {

	private final ICompanyExpensesUsecase usecase;
	private final ModelMapper mapper;

	@Transactional
	public ResponseEntity<CompanyExpensesRequest> save(CompanyExpensesRequest request) {
		CompanyExpenses model = this.usecase.save(this.toModel(request));
		CompanyExpensesRequest expensesRequest = toRequest(model);
		return ok().body(expensesRequest);
	}

	@Override
	public ResponseEntity<PageSearchResult<List<CompanyExpensesRequest>>> search(PageSearchRequest<CompanyExpensesSearchRequest> request) {
		Page<CompanyExpenses> page = this.usecase.findMany(companyExpensesSpecification(request.getSearchRequest()), request.getPage().toPageable());
		List<CompanyExpensesRequest> requests = page.getContent().stream().map(this::toRequest).collect(Collectors.toList());
		return ok().body(toPageSearchResult(requests, page));
	}

	public CompanyExpensesRequest toRequest(CompanyExpenses model) {
		return this.mapper.map(model, CompanyExpensesRequest.class);
	}

	public CompanyExpenses toModel(CompanyExpensesRequest request) {
		return this.mapper.map(request, CompanyExpenses.class);
	}


}