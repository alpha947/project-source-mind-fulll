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


package com.sourcemind.pfe.istock.features.stock.domain.entity;

import com.sourcemind.pfe.istock.core.base.BaseModel;
import com.sourcemind.pfe.istock.features.company.domain.entity.CompanySupplier;
import com.sourcemind.pfe.istock.features.product.domain.entity.Product;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

import static com.sourcemind.pfe.istock.core.constants.Table.STOCK_ITEM;
import static com.sourcemind.pfe.istock.core.constants.Table.STOCK_ITEM_EXPENSES;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = STOCK_ITEM)
@Getter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StockItem extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate recordedDate;
    private Integer productQuantity;
    private Integer productQuantitySold;
    private String other;

    @OneToOne
    private CompanySupplier supplier;

    @OneToOne
    private Product product;

    @OneToOne
    private StockSettlement settlement;

    @OneToOne
    private StockPrice stockPrice;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Stock stock;

    @OneToMany
    @JoinTable(
            name = STOCK_ITEM_EXPENSES,
            joinColumns = @JoinColumn(name = "item_id"),
            inverseJoinColumns = @JoinColumn(name = "expenses_id")
    )
    private List<StockExpenses> expenses;

}
