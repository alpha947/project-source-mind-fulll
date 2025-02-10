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
import com.sourcemind.pfe.istock.features.settings.domain.entity.Setting;
import com.sourcemind.pfe.istock.features.settings.domain.entity.SettingStock;
import com.sourcemind.pfe.istock.features.settings.domain.usecase.ISettingUsecase;
import com.sourcemind.pfe.istock.features.stock.data.repository.StockRepository;
import com.sourcemind.pfe.istock.features.stock.domain.entity.Stock;
import com.sourcemind.pfe.istock.features.stock.domain.usecase.IStockUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import static com.sourcemind.pfe.istock.core.constants.Setting.*;

@Usecase
@RequiredArgsConstructor
public class StockUsecaseImpl implements IStockUsecase {
	private final StockRepository repository;
	private final ISettingUsecase<SettingStock> settingUsecase;


	@Override
	public Stock save(Stock stock) {
		return this.repository.save(stock);
	}


	@Override
	public Stock setCodeAndSave(Stock stock) {
		stock.setCodePrefix(this.getStockPrefix());
		stock.setCode(this.generateCode());
		return this.save(stock);
	}

	@Override
	public Optional<Stock> findOne(Long id) {
		return Optional.empty();
	}

	@Override
	public Page<Stock> findMany(Specification<Stock> specification, Pageable pageable) {
		return null;
	}

	@Override
	public List<Stock> findMany(Specification<Stock> specification) {
		return null;
	}

	private Integer generateCode() {
		Stock stock = this.repository.findTopByOrderByIdDesc();

		if (stock == null) {
			return STOCK_CODE_DEFAULT_START;
		}
		return new AtomicInteger(stock.getCode()).incrementAndGet();
	}

	private String getStockPrefix() {
		Optional<SettingStock> optionalSettings = this.settingUsecase.get(SETTING_STOCK_BATCH_PREFIX_VALUE);
		return optionalSettings.map(Setting::getSettingValue).orElse(STOCK_PREFIX_DEFAULT);
	}
}
