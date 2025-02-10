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
import com.sourcemind.pfe.istock.features.stock.data.repository.StockSettlementRepository;
import com.sourcemind.pfe.istock.features.stock.domain.entity.StockSettlement;
import com.sourcemind.pfe.istock.features.stock.domain.usecase.IStockSettlementUsecase;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Usecase
@RequiredArgsConstructor
public class StockSettlementUsecaseImpl implements IStockSettlementUsecase {

    private final StockSettlementRepository repository;


    @Override
    public StockSettlement save(StockSettlement settlement) {
        return this.repository.save(settlement);
    }

    @Override
    public Optional<StockSettlement> findOne(Long id) {
        return this.repository.findById(id);
    }

    @Override
    public List<StockSettlement> findMany(List<Long> idList) {
        List<StockSettlement> settlements = new ArrayList<>();
        idList.forEach(id -> this.findOne(id).ifPresent(settlements::add));
        return settlements;
    }

    @Override
    public List<StockSettlement> saveMany(List<StockSettlement> settlements) {
        return this.repository.saveAll(settlements);
    }

    @Override
    public Optional<StockSettlement> updateOne(StockSettlement settlement) {
        Optional<StockSettlement> optionalStockSettlement = this.findOne(settlement.getId());
        return optionalStockSettlement.map(c -> this.save(settlement));
    }
}
