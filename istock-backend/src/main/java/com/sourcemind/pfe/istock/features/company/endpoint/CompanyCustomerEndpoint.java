
package com.sourcemind.pfe.istock.features.company.endpoint;

import com.sourcemind.pfe.istock.core.params.PageSearchRequest;
import com.sourcemind.pfe.istock.core.params.PageSearchResult;
import com.sourcemind.pfe.istock.features.company.data.interactor.contract.ICompanyCustomerInteractor;
import com.sourcemind.pfe.istock.features.company.data.request.CompanyCustomerRequest;
import com.sourcemind.pfe.istock.features.company.data.request.CompanyCustomerSearchRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.sourcemind.pfe.istock.core.constants.Global.API_PREFIX;


@RestController
@RequestMapping(value = API_PREFIX + "/company/customer")
@RequiredArgsConstructor
public class CompanyCustomerEndpoint {

    private final ICompanyCustomerInteractor interactor;


    @PostMapping(value = "/search")
    public ResponseEntity<PageSearchResult<List<CompanyCustomerRequest>>> search(
            @RequestBody PageSearchRequest<CompanyCustomerSearchRequest> request
    ) {
        return this.interactor.search(request);
    }

    @GetMapping(value = "/search-by-term")
    public List<CompanyCustomerRequest> searchWithTerm(@RequestParam String term) {
        return this.interactor.search(term);
    }


    @PostMapping(value = "/create")
    public ResponseEntity<CompanyCustomerRequest> save(@RequestBody CompanyCustomerRequest customer) {
        return this.interactor.save(customer);
    }


    @PutMapping(value = "/update")
    public ResponseEntity<Optional<Boolean>> update(CompanyCustomerRequest customer) {
        return this.interactor.update(customer);
    }


    @PutMapping(value = "/status/{id}")
    public ResponseEntity<Optional<Boolean>> toggleActiveStatus(@PathVariable(value = "id") Long id) {
        return this.interactor.toggleActiveStatus(id);
    }
}
