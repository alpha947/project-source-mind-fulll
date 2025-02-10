
package com.sourcemind.pfe.istock.features.company.data.repository;

import com.sourcemind.pfe.istock.features.company.domain.entity.CompanyExpensesCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyExpensesCategoryRepository extends JpaRepository<CompanyExpensesCategory, Long> {
}
