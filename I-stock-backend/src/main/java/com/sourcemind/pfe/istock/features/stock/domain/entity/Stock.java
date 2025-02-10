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


package com.sourcemind.pfe.istock.features.stock.domain.entity;

import com.sourcemind.pfe.istock.core.base.BaseModel;
import com.sourcemind.pfe.istock.features.stock.domain.enums.StockStatus;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

import static com.sourcemind.pfe.istock.core.constants.Table.STOCK;
import static com.sourcemind.pfe.istock.core.constants.Table.STOCK_GROUP_EXPENSES;


@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = STOCK)
@Getter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Stock extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codePrefix;
    private Integer code;
    private Boolean isGroupedExpenses;
    private Boolean isGroupedSettlement;
    private LocalDate recordDate;
    private LocalDate openDate;
    private LocalDate closedDate;
    private StockStatus status;

    @OneToOne
    private StockSettlement settlement;

    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = STOCK_GROUP_EXPENSES,
            joinColumns = @JoinColumn(name = "stock_id"),
            inverseJoinColumns = @JoinColumn(name = "expenses_id"))
    private List<StockExpenses> expenses;

    @OneToMany(mappedBy = "stock")
    private List<StockItem> stockItems;


}
