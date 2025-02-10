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


package com.sourcemind.pfe.istock.features.product.domain.entity;

import com.sourcemind.pfe.istock.core.base.BaseModel;
import lombok.*;

import javax.persistence.*;
import java.util.List;

import static com.sourcemind.pfe.istock.core.constants.Table.PRODUCT_BASIC;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = PRODUCT_BASIC)
@Getter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductBasic extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private ProductCategory productCategory;

    @ManyToOne
    private ProductUnitOfMeasure unitOfMeasure;

    @ManyToOne
    private ProductStatus status;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn()
    private List<ProductTax> taxes;

    @Column(nullable = false)
    private String productName;

    @Column(unique = true)
    private String sku;

    @Column(unique = true)
    private String barcode;

    private String brandName;
    private String description;
    private Boolean isActive;
    private Boolean useQuantity;
    private Boolean isService;
    private Integer minAgeLimit;
    private Integer lowStockPoint;
    @Column(columnDefinition = "integer default 0")
    private Integer quantity = 0;

    public String title() {
        return String.format("%s %s", this.productName, this.brandName);
    }
}
