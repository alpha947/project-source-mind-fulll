package com.sourcemind.pfe.istock.features.product.domain.entity;

import com.sourcemind.pfe.istock.core.base.BaseModel;
import com.sourcemind.pfe.istock.features.product.domain.enums.ProductVariantType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static com.sourcemind.pfe.istock.core.constants.Table.PRODUCT_VARIATIONS;

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

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = PRODUCT_VARIATIONS)
@Data
public class ProductVariant extends BaseModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true)
	@NotNull(message = "Variant type cannot be null")
	private ProductVariantType variantType;

	private String variantValue;


}