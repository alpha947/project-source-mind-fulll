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

package com.sourcemind.pfe.istock.features.sale.domain.entity;

import com.sourcemind.pfe.istock.core.base.BaseModel;
import com.sourcemind.pfe.istock.features.company.domain.entity.CompanyCustomer;
import com.sourcemind.pfe.istock.features.company.domain.entity.CompanyPaymentOption;
import io.hypersistence.utils.hibernate.type.json.JsonType;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static com.sourcemind.pfe.istock.core.constants.Table.SALES_TRANSACTION;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = SALES_TRANSACTION)
@TypeDef(name = "json", typeClass = JsonType.class)
@Getter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SaleTransaction extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reference;

    private String serial;

    private LocalTime time;

    private LocalDate date;

    @OneToOne
    private CompanyCustomer customer;

    @OneToOne
    private SaleTransactionAmount amount;

    @OneToOne
    private SaleTransactionInstallment installment;

    @OneToMany(mappedBy = "transaction")
    private List<SaleTransactionItem> items;

    @Type(type = "json")
    @Column(columnDefinition = "json")
    private String other;

    @OneToOne
    private CompanyPaymentOption paymentOption;
}
