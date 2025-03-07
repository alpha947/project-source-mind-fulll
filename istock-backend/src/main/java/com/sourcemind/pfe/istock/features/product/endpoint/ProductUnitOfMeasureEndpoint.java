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

package com.sourcemind.pfe.istock.features.product.endpoint;

import com.sourcemind.pfe.istock.features.product.data.interactor.implementation.ProductUnitOfMeasureInteractor;
import com.sourcemind.pfe.istock.features.product.data.request.ProductUnitOfMeasureRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static com.sourcemind.pfe.istock.core.constants.Global.API_PREFIX;

@RestController
@RequestMapping(value = API_PREFIX + "/product/unit-of-measurement")
@RequiredArgsConstructor
public class ProductUnitOfMeasureEndpoint {

	private final ProductUnitOfMeasureInteractor interactor;

	@GetMapping(value = "/get/{id}")
	public ResponseEntity<Optional<ProductUnitOfMeasureRequest>> find(@PathVariable Long id) {
		return this.interactor.find(id);
	}

	@GetMapping("/all")
	public ResponseEntity<List<ProductUnitOfMeasureRequest>> findMany() {
		return this.interactor.findAll();
	}

	@PostMapping("/create")
	public ResponseEntity<Optional<ProductUnitOfMeasureRequest>> save(
			@RequestBody @Valid ProductUnitOfMeasureRequest dto
	) {
		return this.interactor.save(dto);
	}

	@PutMapping("/update")
	public ResponseEntity<Optional<ProductUnitOfMeasureRequest>> update(
			@RequestBody @Valid ProductUnitOfMeasureRequest dto
	) {
		return this.interactor.update(dto);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Optional<Boolean>> remove(@PathVariable Long id) {
		return this.interactor.remove(id);
	}
	
}
