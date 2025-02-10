/**
 * ==========================================================
 * Projet de fin d'études - SourceMind
 *
 * Développé par l'équipe Groupe 1 :
 *  - Alpha Amadou DIALLO (https://github.com/alpha947)
 *    Email : dialloalphaamadou947@gmail.com
 *  - Kouloube KOLIE (https://github.com/kouloube)
 *    Email : kouloubekolie@gmail.com
 *  - Moussa CAMARA (https://github.com/usermoussa)
 *    Email : moussaccamaraa@gmail.com
 *  - Mohamed Mouctar KABA (https://github.com/Mokaba-lab)
 *    Email : mocktarkba@gmail.com
 *
 * Ce projet Spring Boot a été conçu et développé
 * pour démontrer nos compétences techniques et
 * apporter une solution innovante.
 * ==========================================================
 */

package com.sourcemind.pfe.istock.features.company.data.interactor.implementation;

import com.sourcemind.pfe.istock.core.annotations.Usecase;
import com.sourcemind.pfe.istock.core.mapper.Mapper;
import com.sourcemind.pfe.istock.features.company.data.interactor.contract.ICompanyAdministratorSetupInteractor;
import com.sourcemind.pfe.istock.features.company.data.request.CompanyDetailRequest;
import com.sourcemind.pfe.istock.features.company.domain.entity.CompanyAdministratorDetail;
import com.sourcemind.pfe.istock.features.company.domain.usecase.ICompanyAdministratorSetupUsecase;
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
public class CompanyAdministratorSetupInteractorImpl implements ICompanyAdministratorSetupInteractor, Mapper<CompanyDetailRequest, CompanyAdministratorDetail> {
	private final ICompanyAdministratorSetupUsecase usecase;
	private final ModelMapper mapper;


	@Override
	public ResponseEntity<Map<String, String>> getAll() {
		Map<String, String> basicDetailMap = new HashMap<>();
		List<CompanyAdministratorDetail> all = this.usecase.all();
		all.forEach(detail -> appendBasicDetailToMap(detail, basicDetailMap));
		return ok().body(basicDetailMap);
	}

	private void appendBasicDetailToMap(CompanyAdministratorDetail basicDetail, Map<String, String> basicDetailMap) {
		basicDetailMap.put(basicDetail.getSetupKey(), basicDetail.getSetupValue());
	}


	@Override
	public ResponseEntity<Optional<Boolean>> updateMany(List<CompanyDetailRequest> requestList) {
		try {
			List<CompanyAdministratorDetail> list = requestList.stream().map(this::toModel).collect(Collectors.toList());
			this.usecase.updateMany(list);
			return ok().body(of(TRUE));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return ok().body(of(FALSE));
		}
	}

	@Override
	public CompanyDetailRequest toRequest(CompanyAdministratorDetail model) {
		return this.mapper.map(model, CompanyDetailRequest.class);
	}

	@Override
	public CompanyAdministratorDetail toModel(CompanyDetailRequest request) {
		return this.mapper.map(request, CompanyAdministratorDetail.class);
	}
}
