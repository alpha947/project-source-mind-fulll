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


package com.sourcemind.pfe.istock.features.stock.data.interactor.implementation;

import com.sourcemind.pfe.istock.core.annotations.Interactor;
import com.sourcemind.pfe.istock.features.stock.data.interactor.contract.IStockPriceInteractor;
import com.sourcemind.pfe.istock.features.stock.data.request.StockPriceRequest;
import com.sourcemind.pfe.istock.features.stock.domain.entity.StockPrice;
import com.sourcemind.pfe.istock.features.stock.domain.usecase.IStockPriceUsecase;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;


@Interactor
@RequiredArgsConstructor
public class StockPriceInteractor implements IStockPriceInteractor {
	private final IStockPriceUsecase usecase;
	private final ModelMapper mapper;

	@Override
	public StockPriceRequest toRequest(StockPrice model) {
		return this.mapper.map(model, StockPriceRequest.class);
	}

	@Override
	public StockPrice toModel(StockPriceRequest request) {
		return this.mapper.map(request, StockPrice.class);
	}

	@Override
	public StockPrice save(StockPriceRequest request) {
		StockPrice model = toModel(request);
		return this.usecase.save(model);
	}


}
