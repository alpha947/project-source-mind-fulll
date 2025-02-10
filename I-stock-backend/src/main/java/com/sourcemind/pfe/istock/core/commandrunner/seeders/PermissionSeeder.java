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

import com.sourcemind.pfe.istock.features.authentication.data.repository.PermissionRepository;
import com.sourcemind.pfe.istock.features.authentication.data.repository.RoleRepository;
import com.sourcemind.pfe.istock.features.authentication.domain.entity.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashSet;

import static com.sourcemind.pfe.istock.core.commandrunner.seeds.PermissionSeeds.*;
import static com.sourcemind.pfe.istock.core.constants.Setting.DEFAULT_SYS_ROLE;

@Component
@RequiredArgsConstructor
public class PermissionSeeder {
    private final PermissionRepository permissionRepository;
    private final RoleRepository roleRepository;

    public void run() {
        if (this.permissionRepository.count() == 0) {
            runAuthenticationSeeder();
            runCompanyPermissionSeeder();
            runPeoplePermissionSeeder();
            runPaywallPermissionSeeder();
            runProductPermissionSeeder();
            runReportPermissionSeeder();
            runSalePermissionSeeder();
            runSettingsPermissionSeeder();
            runStockPermissionSeeder();
            runSeedRole();
        }
    }

    private void runAuthenticationSeeder() {
        this.permissionRepository.saveAll(AUTH_PERMISSIONS);
        System.out.println("----- seed authentication permission  -----");
    }

    private void runCompanyPermissionSeeder() {
        this.permissionRepository.saveAll(COMPANY_PERMISSIONS);
        System.out.println("----- seed company permission  -----");
    }

    private void runPeoplePermissionSeeder() {
        this.permissionRepository.saveAll(PEOPLE_PERMISSION);
        System.out.println("----- seed people permission  -----");
    }

    private void runPaywallPermissionSeeder() {
        this.permissionRepository.saveAll(PAYWALL_PERMISSIONS);
        System.out.println("----- seed paywall permission  -----");
    }

    private void runProductPermissionSeeder() {
        this.permissionRepository.saveAll(PRODUCT_PERMISSIONS);
        System.out.println("----- seed product permission  -----");
    }

    private void runReportPermissionSeeder() {
        this.permissionRepository.saveAll(REPORT_PERMISSIONS);
        System.out.println("----- seed report permission  -----");
    }

    private void runSalePermissionSeeder() {
        this.permissionRepository.saveAll(SALE_PERMISSIONS);
        System.out.println("----- seed sale permission  -----");
    }

    private void runSettingsPermissionSeeder() {
        this.permissionRepository.saveAll(SETTING_PERMISSIONS);
        System.out.println("----- seed settings permission  -----");
    }

    private void runStockPermissionSeeder() {
        this.permissionRepository.saveAll(STOCK_PERMISSIONS);
        System.out.println("----- seed stock permission  -----");
    }

    private void runSeedRole() {
        if (this.roleRepository.count() == 0 || this.roleRepository.findByNameEqualsIgnoreCase(DEFAULT_SYS_ROLE).isEmpty()) {
            Role role = Role.builder().name(DEFAULT_SYS_ROLE)
                    .description("Default system role")
                    .permissions(new HashSet<>(this.permissionRepository.findAll())).build();
            this.roleRepository.save(role);
            System.out.println("----- seed role  -----");
        }
    }

}
