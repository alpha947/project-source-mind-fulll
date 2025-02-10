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
import com.sourcemind.pfe.istock.features.stock.data.interactor.contract.IStockSettlementInteractor;
import com.sourcemind.pfe.istock.features.stock.data.request.StockSettlementRequest;
import com.sourcemind.pfe.istock.features.stock.domain.entity.StockSettlement;
import com.sourcemind.pfe.istock.features.stock.domain.usecase.IStockSettlementUsecase;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

@Interactor
@RequiredArgsConstructor
public class StockSettlementInteractor implements IStockSettlementInteractor {
	private final IStockSettlementUsecase usecase;
	private final ModelMapper mapper;


	@Override
	public StockSettlement save(StockSettlementRequest request) {
		StockSettlement model = toModel(request);
		return this.usecase.save(model);
	}

	@Override
	public StockSettlementRequest toRequest(StockSettlement model) {
		return this.mapper.map(model, StockSettlementRequest.class);
	}

	@Override
	public StockSettlement toModel(StockSettlementRequest request) {
		return this.mapper.map(request, StockSettlement.class);
	}


}
