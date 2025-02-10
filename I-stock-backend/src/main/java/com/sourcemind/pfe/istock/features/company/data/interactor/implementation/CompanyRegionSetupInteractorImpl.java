
package com.sourcemind.pfe.istock.features.company.data.interactor.implementation;

import com.sourcemind.pfe.istock.core.annotations.Usecase;
import com.sourcemind.pfe.istock.core.mapper.Mapper;
import com.sourcemind.pfe.istock.features.company.data.interactor.contract.ICompanyRegionSetupInteractor;
import com.sourcemind.pfe.istock.features.company.data.request.CompanyDetailRequest;
import com.sourcemind.pfe.istock.features.company.domain.entity.CompanyRegionDetail;
import com.sourcemind.pfe.istock.features.company.domain.usecase.ICompanyRegionSetupUsecase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static java.util.Optional.of;
import static org.springframework.http.ResponseEntity.ok;

@Usecase
@RequiredArgsConstructor
@Slf4j
public class CompanyRegionSetupInteractorImpl implements ICompanyRegionSetupInteractor, Mapper<CompanyDetailRequest, CompanyRegionDetail> {
	private final ICompanyRegionSetupUsecase usecase;
	private final ModelMapper mapper;


	@Override
	public ResponseEntity<Map<String, String>> getAll() {
		Map<String, String> basicDetailMap = new HashMap<>();
		List<CompanyRegionDetail> all = this.usecase.all();
		all.forEach(detail -> appendBasicDetailToMap(detail, basicDetailMap));
		return ok().body(basicDetailMap);
	}

	private void appendBasicDetailToMap(CompanyRegionDetail basicDetail, Map<String, String> basicDetailMap) {
		basicDetailMap.put(basicDetail.getSetupKey(), basicDetail.getSetupValue());
	}


	@Override
	public ResponseEntity<Optional<Boolean>> updateMany(List<CompanyDetailRequest> requestList) {
		try {
			List<CompanyRegionDetail> list = requestList.stream().map(this::toModel).collect(Collectors.toList());
			this.usecase.updateMany(list);
			return ok().body(of(TRUE));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return ok().body(of(FALSE));
		}
	}

	@Override
	public CompanyDetailRequest toRequest(CompanyRegionDetail model) {
		return this.mapper.map(model, CompanyDetailRequest.class);
	}

	@Override
	public CompanyRegionDetail toModel(CompanyDetailRequest request) {
		return this.mapper.map(request, CompanyRegionDetail.class);
	}
}
