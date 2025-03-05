package com.sourcemind.pfe.istock.features.company.data.repository;

import com.sourcemind.pfe.istock.features.company.domain.entity.CompanyBusinessCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyBusinessCategoryRepository extends JpaRepository<CompanyBusinessCategory, Long> {
}
