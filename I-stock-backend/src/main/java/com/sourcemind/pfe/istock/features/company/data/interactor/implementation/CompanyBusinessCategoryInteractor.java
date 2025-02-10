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

import com.sourcemind.pfe.istock.core.annotations.Interactor;
import com.sourcemind.pfe.istock.core.mapper.Mapper;
import com.sourcemind.pfe.istock.features.company.data.interactor.contract.ICompanyBusinessCategoryInteractor;
import com.sourcemind.pfe.istock.features.company.data.request.CompanyBusinessCategoryRequest;
import com.sourcemind.pfe.istock.features.company.domain.entity.CompanyBusinessCategory;
import com.sourcemind.pfe.istock.features.company.domain.usecase.ICompanyBusinessCategoryUsecase;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.http.ResponseEntity.ok;

@Interactor
@RequiredArgsConstructor
public class CompanyBusinessCategoryInteractor implements ICompanyBusinessCategoryInteractor, Mapper<CompanyBusinessCategoryRequest, CompanyBusinessCategory> {

	private final ICompanyBusinessCategoryUsecase usecase;
	private final ModelMapper mapper;

	@Override
	public ResponseEntity<List<CompanyBusinessCategoryRequest>> getAll() {
		List<CompanyBusinessCategory> list = this.usecase.getAll();
		List<CompanyBusinessCategoryRequest> requests = list.stream().map(this::toRequest).collect(Collectors.toList());
		return ok().body(requests);
	}

	@Override
	public ResponseEntity<Optional<CompanyBusinessCategoryRequest>> getOne(Long id) {
		Optional<CompanyBusinessCategory> optional = this.usecase.getOne(id);
		return ok().body(optional.map(this::toRequest));
	}

	@Override
	public CompanyBusinessCategoryRequest toRequest(CompanyBusinessCategory model) {
		return this.mapper.map(model, CompanyBusinessCategoryRequest.class);
	}

	@Override
	public CompanyBusinessCategory toModel(CompanyBusinessCategoryRequest request) {
		return this.mapper.map(request, CompanyBusinessCategory.class);
	}
}
