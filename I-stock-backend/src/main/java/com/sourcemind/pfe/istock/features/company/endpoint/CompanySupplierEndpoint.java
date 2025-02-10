
package com.sourcemind.pfe.istock.features.company.endpoint;

import com.sourcemind.pfe.istock.core.params.PageSearchRequest;
import com.sourcemind.pfe.istock.core.params.PageSearchResult;
import com.sourcemind.pfe.istock.features.company.data.interactor.contract.ICompanySupplierInteractor;
import com.sourcemind.pfe.istock.features.company.data.request.CompanySupplierRequest;
import com.sourcemind.pfe.istock.features.company.data.request.CompanySupplierSearchRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.sourcemind.pfe.istock.core.constants.Global.API_PREFIX;


@RestController
@RequestMapping(value = API_PREFIX + "/company/supplier")
@RequiredArgsConstructor
public class CompanySupplierEndpoint {

	private final ICompanySupplierInteractor interactor;


	@PostMapping(value = "/search-request")
	public ResponseEntity<PageSearchResult<List<CompanySupplierRequest>>> search(
			@RequestBody PageSearchRequest<CompanySupplierSearchRequest> request
	) {
		return this.interactor.search(request);
	}

	@GetMapping("search")
	public ResponseEntity<List<CompanySupplierRequest>> search(
			@RequestParam(value = "term") String term
	) {
		return this.interactor.search(term);
	}
	
	@PostMapping(value = "/create")
	public ResponseEntity<CompanySupplierRequest> save(@RequestBody CompanySupplierRequest request) {
		return this.interactor.save(request);
	}


	@PutMapping(value = "/update")
	public ResponseEntity<Optional<Boolean>> update(CompanySupplierRequest request) {
		return this.interactor.update(request);
	}


	@PutMapping(value = "/status/{id}")
	public ResponseEntity<Optional<Boolean>> toggleActiveStatus(@PathVariable(value = "id") Long id) {
		return this.interactor.toggleActiveStatus(id);
	}
}
