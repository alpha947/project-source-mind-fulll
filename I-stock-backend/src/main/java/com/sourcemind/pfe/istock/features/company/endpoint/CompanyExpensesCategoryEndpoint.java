
package com.sourcemind.pfe.istock.features.company.endpoint;

import com.sourcemind.pfe.istock.features.company.data.interactor.contract.ICompanyExpensesCategoryInteractor;
import com.sourcemind.pfe.istock.features.company.data.request.CompanyExpensesCategoryRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static com.sourcemind.pfe.istock.core.constants.Global.API_PREFIX;

@RestController
@RequestMapping(value = API_PREFIX + "/company/expenses/category")
@RequiredArgsConstructor
public class CompanyExpensesCategoryEndpoint {
	private final ICompanyExpensesCategoryInteractor interactor;

	@PostMapping(value = "create")
	public ResponseEntity<CompanyExpensesCategoryRequest> save(@RequestBody CompanyExpensesCategoryRequest category) {
		return this.interactor.save(category);
	}

	@GetMapping(value = "all")
	public ResponseEntity<List<CompanyExpensesCategoryRequest>> findAll() {
		return this.interactor.findAll();
	}

	@GetMapping(value = "get/{id}")
	public ResponseEntity<Optional<CompanyExpensesCategoryRequest>> findOne(@PathVariable Long id) {
		return this.interactor.findOne(id);
	}

	@PutMapping("update")
	public ResponseEntity<Optional<CompanyExpensesCategoryRequest>> update(
			@RequestBody @Valid CompanyExpensesCategoryRequest request
	) {
		return this.interactor.update(request);
	}

}
