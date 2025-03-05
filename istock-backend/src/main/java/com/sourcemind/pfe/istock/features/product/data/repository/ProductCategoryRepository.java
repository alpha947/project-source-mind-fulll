package com.sourcemind.pfe.istock.features.product.data.repository;
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

import com.sourcemind.pfe.istock.features.product.domain.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * @author Aworo James
 * @since 5/10/23
 */
@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
	Optional<ProductCategory> findByTitle(String title);

	List<ProductCategory> findAllByTitleContainsIgnoreCase(String title);

	@Transactional
	@Modifying
	@Query(value = "update ProductCategory c set c.isActiveStatus = :status where c.id = :id")
	int updateIsActiveStatus(@Param(value = "status") Boolean status, @Param(value = "id") Long id);
}