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

package com.sourcemind.pfe.istock.features.product.data.interactor.implementation;

import com.sourcemind.pfe.istock.core.annotations.Interactor;
import com.sourcemind.pfe.istock.core.mapper.Mapper;
import com.sourcemind.pfe.istock.features.product.data.interactor.contract.IProductUnitOfMeasureInteractor;
import com.sourcemind.pfe.istock.features.product.data.request.ProductUnitOfMeasureRequest;
import com.sourcemind.pfe.istock.features.product.domain.entity.ProductUnitOfMeasure;
import com.sourcemind.pfe.istock.features.product.domain.usecase.IProductUnitOfMeasureUsecase;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.sourcemind.pfe.istock.core.constants.Exception.RECORD_NOT_FOUND;
import static com.sourcemind.pfe.istock.core.constants.Exception.REQUIRED_ID;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.ResponseEntity.ok;

@Interactor
@RequiredArgsConstructor
public class ProductUnitOfMeasureInteractor implements IProductUnitOfMeasureInteractor, Mapper<ProductUnitOfMeasureRequest, ProductUnitOfMeasure> {

	private final IProductUnitOfMeasureUsecase usecase;
	private final ModelMapper mapper;

	@Override
	public ResponseEntity<List<ProductUnitOfMeasureRequest>> findAll() {
		List<ProductUnitOfMeasure> modelList = usecase.findAll();
		List<ProductUnitOfMeasureRequest> requestList = modelList.stream().map(this::toRequest).collect(Collectors.toList());
		return ok(requestList);
	}

	@Override
	public ResponseEntity<Optional<ProductUnitOfMeasureRequest>> save(ProductUnitOfMeasureRequest request) {
		Optional<ProductUnitOfMeasure> save = this.usecase.save(toModel(request));
		return ok(save.map(this::toRequest));
	}


	@Override
	public ResponseEntity<Optional<Boolean>> remove(Long id) {
		return ok(this.usecase.remove(id));
	}

	@Override
	public ResponseEntity<Optional<ProductUnitOfMeasureRequest>> find(Long id) {
		Optional<ProductUnitOfMeasure> optional = this.usecase.findOne(id);
		return ok(optional.map(this::toRequest));
	}

	@Override
	public ResponseEntity<Optional<ProductUnitOfMeasureRequest>> update(ProductUnitOfMeasureRequest request) {
		this.throwIfRequestNotValid(request);
		return this.save(request);
	}

	@Override
	public ProductUnitOfMeasure toModel(ProductUnitOfMeasureRequest request) {
		return this.mapper.map(request, ProductUnitOfMeasure.class);
	}

	@Override
	public ProductUnitOfMeasureRequest toRequest(ProductUnitOfMeasure model) {
		return this.mapper.map(model, ProductUnitOfMeasureRequest.class);
	}

	private void throwIfRequestNotValid(ProductUnitOfMeasureRequest request) {
		if (ObjectUtils.isEmpty(request.getId())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, REQUIRED_ID);
		}

		if (!this.find(request.getId()).getStatusCode().is2xxSuccessful()) {
			throw new ResponseStatusException(NOT_FOUND, RECORD_NOT_FOUND);
		}
	}
}
