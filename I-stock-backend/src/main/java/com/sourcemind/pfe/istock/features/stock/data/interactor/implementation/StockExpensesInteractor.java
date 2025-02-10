/**
 * ==========================================================
 * Projet de fin d'études - SourceMind
 *
 * Développé par l'équipe Groupe 4 :
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
import com.sourcemind.pfe.istock.features.stock.data.interactor.contract.IStockExpensesInteractor;
import com.sourcemind.pfe.istock.features.stock.data.request.StockExpensesRequest;
import com.sourcemind.pfe.istock.features.stock.domain.entity.StockExpenses;
import com.sourcemind.pfe.istock.features.stock.domain.usecase.IStockExpensesUsecase;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

@Interactor
@RequiredArgsConstructor
public class StockExpensesInteractor implements IStockExpensesInteractor {
    private final IStockExpensesUsecase usecase;
    private final ModelMapper mapper;


    @Override
    public StockExpenses saveOne(StockExpensesRequest request) {
        StockExpenses expenses = toModel(request);
        return this.usecase.save(expenses);
    }

    @Override
    public List<StockExpenses> saveMany(List<StockExpensesRequest> request) {
        List<StockExpenses> expenses = new ArrayList<>();
        request.forEach(stockExpensesRequest -> expenses.add(this.saveOne(stockExpensesRequest)));
        return expenses;
    }

    @Override
    public StockExpensesRequest toRequest(StockExpenses model) {
        return this.mapper.map(model, StockExpensesRequest.class);
    }

    @Override
    public StockExpenses toModel(StockExpensesRequest request) {
        return this.mapper.map(request, StockExpenses.class);
    }

}
