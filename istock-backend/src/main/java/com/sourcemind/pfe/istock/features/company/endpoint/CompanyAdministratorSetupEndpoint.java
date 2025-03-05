
package com.sourcemind.pfe.istock.features.company.endpoint;

import com.sourcemind.pfe.istock.features.company.data.interactor.contract.ICompanyAdministratorSetupInteractor;
import com.sourcemind.pfe.istock.features.company.data.request.CompanyDetailRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.sourcemind.pfe.istock.core.constants.Global.API_PREFIX;

@RestController
@RequestMapping(value = API_PREFIX + "/company/setup/administrator")
@RequiredArgsConstructor
public class CompanyAdministratorSetupEndpoint {

	private final ICompanyAdministratorSetupInteractor interactor;

	@GetMapping(value = "get-all")
	public ResponseEntity<Map<String, String>> getAll() {
		return this.interactor.getAll();
	}
	

	@PostMapping(value = "update-many")
	public ResponseEntity<Optional<Boolean>> update(@RequestBody List<CompanyDetailRequest> requestList) {
		return this.interactor.updateMany(requestList);
	}
}
