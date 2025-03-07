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

package com.sourcemind.pfe.istock.core.commandrunner.seeders;

import com.sourcemind.pfe.istock.features.company.data.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static com.sourcemind.pfe.istock.core.commandrunner.seeds.CompanySeeds.*;

@Component
@RequiredArgsConstructor
public class CompanySeeder {
	private final CompanyExpensesCategoryRepository companyExpensesCategoryRepository;
	private final CompanyBusinessCategoryRepository companyBusinessCategoryRepository;
	private final CompanyBasicDetailRepository companyBasicDetailRepository;
	private final CompanyAdministratorDetailRepository companyAdministratorDetailRepository;
	private final CompanyRegionDetailRepository companyLocaleDetailRepository;


	public void run() {
		this.runCompanyExpensesCategorySeeder();
		this.runCompanyBusinessCategorySeeder();
		this.runCompanyBasicDetailsSeeder();
		this.runCompanyAdminDetailsSeeder();
		this.runCompanyLocaleDetailsSeeder();

	}

	private void runCompanyExpensesCategorySeeder() {
		if (this.companyExpensesCategoryRepository.count() == 0) {
			this.companyExpensesCategoryRepository.saveAll(COMPANY_EXPENSES_CATEGORIES);
			System.out.println("----- catégories de dépenses des entreprises semencières -----");
		}
	}

	private void runCompanyBusinessCategorySeeder() {
		if (companyBusinessCategoryRepository.count() == 0) {
			this.companyBusinessCategoryRepository.saveAll(COMPANY_BUSINESS_CATEGORIES);
			System.out.println("----- catégories d'activités des entreprises semencières -----");
		}
	}

	private void runCompanyBasicDetailsSeeder() {
		if (companyBasicDetailRepository.count() == 0) {
			this.companyBasicDetailRepository.saveAll(COMPANY_BASIC_DETAILS);
			System.out.println("----- clés de configuration de base de la société de semences -----");
		}

	}

	private void runCompanyAdminDetailsSeeder() {
		if (companyAdministratorDetailRepository.count() == 0) {
			this.companyAdministratorDetailRepository.saveAll(COMPANY_ADMINISTRATOR_DETAILS);
			System.out.println("----- clés de configuration de l'administrateur de la société semencière -----");
		}
	}

	private void runCompanyLocaleDetailsSeeder() {
		if (companyLocaleDetailRepository.count() == 0) {
			this.companyLocaleDetailRepository.saveAll(COMPANY_LOCALE_DETAILS);
			System.out.println("----- clés de configuration de la région de la société semencière -----");
		}
	}
}
