package com.sourcemind.pfe.istock.core.commandrunner.seeders;

import com.sourcemind.pfe.istock.core.constants.enums.PaymentMethod;
import com.sourcemind.pfe.istock.features.settings.data.repository.*;
import com.sourcemind.pfe.istock.features.settings.domain.entity.SettingPaymentMethod;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

import static com.sourcemind.pfe.istock.core.commandrunner.seeds.SettingsSeeds.*;
import static java.util.Arrays.stream;

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
@Component
@RequiredArgsConstructor
public class SettingSeeder {

	private final SettingBackupRestoreRepository backupRestoreRepository;
	private final SettingDashboardRepository dashboardRepository;
	private final SettingExpensesRepository expensesRepository; 
	private final SettingPaymentMethodRepository paymentMethodRepository;
	private final SettingTaxRepository taxRepository;
	private final SettingStockRepository stockRepository;
	private final SettingPeopleRepository peopleRepository;
	private final SettingProductRepository productRepository;
	private final SettingSaleRepository saleRepository;


	public void run() {
		this.seedBackupAndRestore();
		this.seedDashboardSetting();
		this.seedExpensesSetting();
		this.seedTaxSetting();
		this.seedPaymentMethod();
		this.seedStockSetting();
		this.seedPeopleSetting();
		this.seedProductSetting();
		this.seedSaleSetting();
	}


	private void seedBackupAndRestore() {
		if (this.backupRestoreRepository.count() == 0) {
			this.backupRestoreRepository.saveAll(SETTING_BACK_UP_RESTORES);
			System.out.println("----- paramètres de restauration de sauvegarde de semences -----");
		}
	}

	private void seedDashboardSetting() {
		if (this.dashboardRepository.count() == 0) {
			this.dashboardRepository.saveAll(SETTING_DASHBOARDS);
			System.out.println("----- paramètres du tableau de bord des semences -----");
		}
	}

	private void seedExpensesSetting() {
		if (this.expensesRepository.count() == 0) {
			this.expensesRepository.saveAll(SETTING_EXPENSES);
			System.out.println("----- paramètres des dépenses de semences -----");
		}
	}

	private void seedTaxSetting() {
		if (this.taxRepository.count() == 0) {
			this.taxRepository.saveAll(SETTING_TAXES);
			System.out.println("----- paramètres de taxe sur les semences -----");
		}
	}

	private void seedStockSetting() {
		if (this.stockRepository.count() == 0) {
			this.stockRepository.saveAll(SETTING_STOCKS);
			System.out.println("----- paramètres de stock de semences -----");
		}
	}

	private void seedPaymentMethod() {
		if (this.paymentMethodRepository.count() == 0) {
			var settings = new ArrayList<SettingPaymentMethod>();
			PaymentMethod[] values = PaymentMethod.values();
			stream(values).map(v -> new SettingPaymentMethod(v.name())).forEach(settings::add);
			this.paymentMethodRepository.saveAll(settings);
			System.out.println("----- méthode de paiement des semences -----");
		}
	}

	private void seedPeopleSetting() {
		if (this.peopleRepository.count() == 0) {
			this.peopleRepository.saveAll(SETTING_PEOPLE);
			System.out.println("----- réglage des semences -----");
		}
	}

	private void seedProductSetting() {
		if (this.productRepository.count() == 0) {
			this.productRepository.saveAll(SETTING_PRODUCTS);
			System.out.println("----- réglage du produit de semence -----");
		}
	}

	private void seedSaleSetting() {
		if (this.saleRepository.count() == 0) {
			this.saleRepository.saveAll(SETTING_SALES);
			System.out.println("----- paramètre de vente de semences -----");
		}
	}


}