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

package com.sourcemind.pfe.istock.features.stock.domain.usecase;

import com.sourcemind.pfe.istock.features.stock.domain.entity.StockItem;

import java.util.List;
import java.util.Optional;


public interface IStockItemUsecase {

	StockItem save(StockItem item);

	Optional<StockItem> findOne(Long id);

	List<StockItem> findMany(List<Long> idList);

	List<StockItem> saveMany(List<StockItem> items);
}
