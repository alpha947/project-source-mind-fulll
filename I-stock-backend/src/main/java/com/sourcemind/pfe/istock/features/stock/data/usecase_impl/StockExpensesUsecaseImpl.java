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
import com.sourcemind.pfe.istock.features.stock.data.repository.StockExpensesRepository;
import com.sourcemind.pfe.istock.features.stock.domain.entity.StockExpenses;
import com.sourcemind.pfe.istock.features.stock.domain.usecase.IStockExpensesUsecase;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Usecase
@RequiredArgsConstructor
public class StockExpensesUsecaseImpl implements IStockExpensesUsecase {
    private final StockExpensesRepository repository;

    @Override
    public StockExpenses save(StockExpenses expenses) {
        return this.repository.save(expenses);
    }

    @Override
    public Optional<StockExpenses> findOne(Long id) {
        return this.repository.findById(id);
    }

    @Override
    public List<StockExpenses> findMany(List<Long> idList) {
        List<StockExpenses> expenses = new ArrayList<>();
        idList.forEach(id -> this.findOne(id).ifPresent(expenses::add));
        return expenses;
    }

    @Override
    public List<StockExpenses> saveMany(List<StockExpenses> expenses) {
        return this.repository.saveAll(expenses);
    }

    @Override
    public Optional<StockExpenses> updateOne(StockExpenses expenses) {
        Optional<StockExpenses> optionalExpenses = this.findOne(expenses.getId());
        return optionalExpenses.map(c -> this.save(expenses));
    }
}
