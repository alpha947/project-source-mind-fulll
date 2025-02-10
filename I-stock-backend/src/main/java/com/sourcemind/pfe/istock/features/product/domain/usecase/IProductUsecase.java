package com.sourcemind.pfe.istock.features.product.domain.usecase;

import com.sourcemind.pfe.istock.core.params.FileHandler;
import com.sourcemind.pfe.istock.features.product.domain.entity.Product;
import com.sourcemind.pfe.istock.features.product.domain.entity.ProductPrice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Optional;

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

public interface IProductUsecase extends FileHandler<Map<String, String>, MultipartFile> {

    Optional<Product> findById(Long id);

    Product save(Product product);

    Page<Product> findMany(Specification<Product> specification, Pageable pageable);

    List<Product> findMany(Specification<Product> specification);

    void updateProductQuantity(Product product, Integer quantity);

    void tryUpdateProductPrice(Product product, ProductPrice productPrice);

    void deductProductQuantityAfterSales(Product product, Integer deductBy);
}