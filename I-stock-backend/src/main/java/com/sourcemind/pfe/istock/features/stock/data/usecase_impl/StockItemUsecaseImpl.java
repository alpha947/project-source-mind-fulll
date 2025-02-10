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
import com.sourcemind.pfe.istock.features.stock.data.repository.StockItemRepository;
import com.sourcemind.pfe.istock.features.stock.domain.entity.StockItem;
import com.sourcemind.pfe.istock.features.stock.domain.usecase.IStockItemUsecase;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;


@Usecase
@RequiredArgsConstructor
public class StockItemUsecaseImpl implements IStockItemUsecase {
    private final StockItemRepository repository;

    @Override
    public StockItem save(StockItem item) {
        return this.repository.save(item);
    }

    @Override
    public Optional<StockItem> findOne(Long id) {
        return this.repository.findById(id);
    }

    @Override
    public List<StockItem> findMany(List<Long> idList) {
        return this.repository.findAllById(idList);
    }

    @Override
    public List<StockItem> saveMany(List<StockItem> items) {
        return this.repository.saveAll(items);
    }
}
