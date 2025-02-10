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


package com.sourcemind.pfe.istock.features.stock.data.usecase_impl;

import com.sourcemind.pfe.istock.core.annotations.Usecase;
import com.sourcemind.pfe.istock.features.stock.data.repository.StockPriceRepository;
import com.sourcemind.pfe.istock.features.stock.domain.entity.StockPrice;
import com.sourcemind.pfe.istock.features.stock.domain.usecase.IStockPriceUsecase;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Usecase
@RequiredArgsConstructor
public class StockPriceUsecaseImpl implements IStockPriceUsecase {

	private final StockPriceRepository repository;

	@Override
	public StockPrice save(StockPrice price) {
		return this.repository.save(price);
	}

	@Override
	public Optional<StockPrice> findOne(Long id) {
		return this.repository.findById(id);
	}

	@Override
	public List<StockPrice> findMany(List<Long> idList) {
		List<StockPrice> stockPrices = new ArrayList<>();
		idList.forEach(id -> {
			Optional<StockPrice> optionalStockPrice = this.findOne(id);
			optionalStockPrice.ifPresent(stockPrices::add);
		});
		return stockPrices;
	}

	@Override
	public List<StockPrice> saveMany(List<StockPrice> price) {
		return this.repository.saveAll(price);
	}

	@Override
	public Optional<StockPrice> updateOne(StockPrice price) {
		Optional<StockPrice> optionalStockPrice = this.findOne(price.getId());
		return optionalStockPrice.map(this::save);
	}
}
