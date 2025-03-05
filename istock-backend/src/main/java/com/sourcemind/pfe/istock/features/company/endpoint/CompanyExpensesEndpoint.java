package com.sourcemind.pfe.istock.features.company.endpoint;

import com.sourcemind.pfe.istock.core.params.PageSearchRequest;
import com.sourcemind.pfe.istock.core.params.PageSearchResult;
import com.sourcemind.pfe.istock.features.company.data.interactor.contract.ICompanyExpensesInteractor;
import com.sourcemind.pfe.istock.features.company.data.request.CompanyExpensesRequest;
import com.sourcemind.pfe.istock.features.company.data.request.CompanyExpensesSearchRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

import static com.sourcemind.pfe.istock.core.constants.Global.API_PREFIX;


@RestController
@RequestMapping(value = API_PREFIX + "/company/expenses")
@RequiredArgsConstructor
public class CompanyExpensesEndpoint {

	private final ICompanyExpensesInteractor interactor;

	@PostMapping(value = "/create")
	public ResponseEntity<CompanyExpensesRequest> create(@RequestBody CompanyExpensesRequest request) {
		return this.interactor.save(request);
	}

	@PostMapping(value = "/search")
	public ResponseEntity<PageSearchResult<List<CompanyExpensesRequest>>> search(
			@Valid @RequestBody PageSearchRequest<CompanyExpensesSearchRequest> request
	) {
		return this.interactor.search(request);
	}
}