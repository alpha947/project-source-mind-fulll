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
import com.sourcemind.pfe.istock.core.params.PageSearchRequest;
import com.sourcemind.pfe.istock.core.params.PageSearchResult;
import com.sourcemind.pfe.istock.core.utils.Util;
import com.sourcemind.pfe.istock.features.stock.data.interactor.contract.IStockExpensesInteractor;
import com.sourcemind.pfe.istock.features.stock.data.interactor.contract.IStockInteractor;
import com.sourcemind.pfe.istock.features.stock.data.interactor.contract.IStockItemInteractor;
import com.sourcemind.pfe.istock.features.stock.data.interactor.contract.IStockSettlementInteractor;
import com.sourcemind.pfe.istock.features.stock.data.request.*;
import com.sourcemind.pfe.istock.features.stock.data.request.*;
import com.sourcemind.pfe.istock.features.stock.domain.entity.Stock;
import com.sourcemind.pfe.istock.features.stock.domain.entity.StockExpenses;
import com.sourcemind.pfe.istock.features.stock.domain.entity.StockSettlement;
import com.sourcemind.pfe.istock.features.stock.domain.usecase.IStockUsecase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.sourcemind.pfe.istock.features.stock.domain.enums.StockStatus.REGISTERED;
import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.util.ObjectUtils.isEmpty;

@Interactor
@RequiredArgsConstructor
@Slf4j
public class StockInteractor implements IStockInteractor {

    private final ModelMapper mapper;
    private final IStockUsecase usecase;
    private final IStockSettlementInteractor settlementInteractor;
    private final IStockExpensesInteractor expensesInteractor;
    private final IStockItemInteractor itemInteractor;


    @Override
    @Transactional
    public ResponseEntity<StockRequest> save(StockRequest request) {
        try {
            Stock newStock = this.createNewStock(request);
            this.updateStockSettlementIfIsGroupEnabled(newStock, request.getSettlement());
            this.updateStockExpensesIfGroupEnable(newStock, new ArrayList<>(request.getExpenses()));
            this.updateStockItemsAfterCreatingStock(newStock, new ArrayList<>(request.getStockItems()));
            return ok().body(request);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        }
    }



    private Stock createNewStock(StockRequest request) {
        Stock stock = new Stock();
        stock.setIsGroupedExpenses(request.getIsGroupedExpenses());
        stock.setIsGroupedSettlement(request.getIsGroupedSettlement());
        stock.setRecordDate(Util.parseToLocalDate(request.getRecordDate()));
        stock.setStatus(REGISTERED);
        Stock savedStock = this.usecase.setCodeAndSave(stock);
        request.setId(savedStock.getId());
        return savedStock;
    }


    /**
     * Updates the stock settlement if the stock is enabled for grouped settlement.
     * <p>
     * Operation Steps:
     * - Checks if the stock has the "isGroupedSettlement" flag set to true.
     * - If true, saves the stock settlement using the settlementInteractor.
     * - Assigns the saved settlement to the stock.
     * - Saves the updated stock using the usecase.
     *
     * @param stock   The Stock object to be updated.
     * @param request The StockSettlementRequest object containing the settlement data.
     */
    private void updateStockSettlementIfIsGroupEnabled(Stock stock, StockSettlementRequest request) {
        if (stock.getIsGroupedSettlement()) {
            StockSettlement settlement = this.settlementInteractor.save(request);
            stock.setSettlement(settlement);
            this.usecase.save(stock);
        }
    }


    /**
     * Updates the stock expenses if the stock is enabled for grouped expenses and if there are any expense requests provided.
     * <p>
     * Operation Steps:
     * - Checks if the stock has the "isGroupedExpenses" flag set to true and if there are any expense requests.
     * - If true, saves the expense requests using the expensesInteractor.
     * - Assigns the saved expenses to the stock.
     * - Saves the updated stock using the usecase.
     *
     * @param stock            The Stock object to be updated.
     * @param expensesRequests The list of StockExpensesRequest objects containing the expense data.
     */
    private void updateStockExpensesIfGroupEnable(Stock stock, List<StockExpensesRequest> expensesRequests) {
        if (stock.getIsGroupedExpenses() && expensesRequests != null) {
            List<StockExpenses> expenses = this.expensesInteractor.saveMany(expensesRequests);
            stock.setExpenses(expenses);
            this.usecase.save(stock);
        }
    }


    /**
     * Updates the stock items after creating a stock.
     * <p>
     * Steps:
     * - Checks if the stockItems list is not empty.
     * - If not empty, saves the stock items using the itemInteractor and associates them with the given stock.
     *
     * @param stock      The Stock object for which the items are being updated.
     * @param stockItems The list of StockItemRequest objects containing the item data.
     */
    private void updateStockItemsAfterCreatingStock(Stock stock, List<StockItemRequest> stockItems) {
        if (!isEmpty(stockItems)) {
            this.itemInteractor.saveMany(stockItems, stock);
        }
    }

    @Override
    public ResponseEntity<PageSearchResult<List<StockRequest>>> search(PageSearchRequest<StockSearchRequest> request) {
        return null;
    }

    @Override
    public ResponseEntity<List<StockRequest>> search(String term) {
        return null;
    }

    @Override
    public ResponseEntity<PageSearchResult<StockCounterResponse>> countStock(StockCounterRequest request) {
        return null;
    }


    /**
     * Converts a Stock model object to a StockRequest object.
     *
     * @param model The Stock object to be converted.
     * @return The converted StockRequest object.
     */
    @Override
    public StockRequest toRequest(Stock model) {
        return this.mapper.map(model, StockRequest.class);
    }


    /**
     * Converts a StockRequest object to a Stock model object.
     *
     * @param request The StockRequest object to be converted.
     * @return The converted Stock model object.
     */
    @Override
    public Stock toModel(StockRequest request) {
        return this.mapper.map(request, Stock.class);
    }

}

