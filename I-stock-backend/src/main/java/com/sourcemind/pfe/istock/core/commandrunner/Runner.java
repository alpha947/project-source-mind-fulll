package com.sourcemind.pfe.istock.core.commandrunner;

import com.sourcemind.pfe.istock.core.commandrunner.seeders.CompanySeeder;
import com.sourcemind.pfe.istock.core.commandrunner.seeders.PermissionSeeder;
import com.sourcemind.pfe.istock.core.commandrunner.seeders.SettingSeeder;
import com.sourcemind.pfe.istock.core.commandrunner.seeders.UserSeeder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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
public class Runner implements CommandLineRunner {
    private final SettingSeeder settingSeeder;
    private final CompanySeeder companySeeder;
    private final PermissionSeeder permissionSeeder;
    private final UserSeeder userSeeder;

    @Autowired
    public Runner(
            SettingSeeder settingSeeder,
            CompanySeeder companySeeder,
            PermissionSeeder permissionSeeder,
            UserSeeder userSeeder) {
        this.settingSeeder = settingSeeder;
        this.companySeeder = companySeeder;
        this.permissionSeeder = permissionSeeder;
        this.userSeeder = userSeeder;
    }

    @Override
    public void run(String... args) throws Exception {
        settingSeeder.run();
        companySeeder.run();
        permissionSeeder.run();
        userSeeder.run();
    }
}