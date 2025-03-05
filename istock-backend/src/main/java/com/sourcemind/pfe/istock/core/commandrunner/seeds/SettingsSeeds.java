package com.sourcemind.pfe.istock.core.commandrunner.seeds;

import com.sourcemind.pfe.istock.features.settings.domain.entity.*;

import java.util.Arrays;
import java.util.List;

import static com.sourcemind.pfe.istock.core.constants.Global.FALSE;
import static com.sourcemind.pfe.istock.core.constants.Setting.*;
import static com.sourcemind.pfe.istock.core.constants.enums.SettingField.INPUT;
import static com.sourcemind.pfe.istock.core.constants.enums.SettingField.TOGGLE;
import static com.sourcemind.pfe.istock.features.settings.domain.enums.SettingModule.*;
import static java.util.List.of;

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
public class SettingsSeeds {

    // backup and restore
    public static final List<SettingBackUpRestore> SETTING_BACK_UP_RESTORES = List.of(
            new SettingBackUpRestore(
                    new SettingObj(SETTING_BACKUP_ENABLE_AUTO_BACK_UP, FALSE, TOGGLE,
                            strip(SETTING_BACKUP_ENABLE_AUTO_BACK_UP), BACKUP)
            )
    );

    // dashboard
    public static final List<SettingDashboard> SETTING_DASHBOARDS = List.of(
            new SettingDashboard(
                    new SettingObj(SETTING_DASHBOARD_SHOW_EMPLOYEE_PERFORMANCE, FALSE, TOGGLE,
                            strip(SETTING_DASHBOARD_SHOW_EMPLOYEE_PERFORMANCE), DASHBOARD
                    )
            ),

            new SettingDashboard(
                    new SettingObj(
                            SETTING_DASHBOARD_SHOW_PRODUCT_PERFORMANCE, FALSE, TOGGLE,
                            strip(SETTING_DASHBOARD_SHOW_PRODUCT_PERFORMANCE), DASHBOARD
                    )
            )
    );

    // expenses
    public static final List<SettingExpenses> SETTING_EXPENSES = List.of(
            new SettingExpenses(new SettingObj(
                    SETTING_EXPENSES_ENABLE_EXPENSES_APPROVAL, FALSE, TOGGLE,
                    strip(SETTING_EXPENSES_ENABLE_EXPENSES_APPROVAL), EXPENSES)
            )
    );

    // tax
    public static final List<SettingTax> SETTING_TAXES = List.of(
            new SettingTax(new SettingObj(
                    SETTING_TAX_ENABLE_TAX, FALSE, TOGGLE, strip(SETTING_TAX_ENABLE_TAX), TAX)),

            new SettingTax(new SettingObj(SETTING_TAX_PERCENT_VALUE, "2", INPUT,
                    strip(SETTING_TAX_PERCENT_VALUE), TAX)
            )
    );

    // people
    public static final List<SettingPeople> SETTING_PEOPLE = List.of(
            new SettingPeople(new SettingObj(
                    SETTING_PEOPLE_SHOW_EMPLOYEE_SALES_PERFORMANCE, FALSE, TOGGLE,
                    strip(SETTING_PEOPLE_SHOW_EMPLOYEE_SALES_PERFORMANCE), PEOPLE)
            ),
            new SettingPeople(new SettingObj(SETTING_PEOPLE_SHOW_EMPLOYEE_SHIFT, FALSE, TOGGLE,
                    strip(SETTING_PEOPLE_SHOW_EMPLOYEE_SHIFT), PEOPLE)
            ),
            new SettingPeople(new SettingObj(SETTING_PEOPLE_SHOW_EMPLOYEE_PROFIT_PERFORMANCE, FALSE, TOGGLE,
                    strip(SETTING_PEOPLE_SHOW_EMPLOYEE_PROFIT_PERFORMANCE), PEOPLE)
            ),
            new SettingPeople(new SettingObj(SETTING_PEOPLE_SHOW_TOTAL_CUSTOMER_STATS, FALSE, TOGGLE,
                    strip(SETTING_PEOPLE_SHOW_TOTAL_CUSTOMER_STATS), PEOPLE)
            )
    );

    // stock
    public static final List<SettingStock> SETTING_STOCKS;

    // product
    public static final List<SettingProduct> SETTING_PRODUCTS = of(
            new SettingProduct(new SettingObj(SETTING_PRODUCT_ENABLE_PRODUCT_BUNDLE, FALSE, TOGGLE,
                    strip(SETTING_PRODUCT_ENABLE_PRODUCT_BUNDLE), PRODUCT,
                    "PERMETTRE AUX PRODUITS ET/OU SERVICES D'ÊTRE REGROUPÉS ET FACTURÉS COMME UNE SEULE UNITÉ")
            ),

            new SettingProduct(new SettingObj(SETTING_PRODUCT_SHOW_PRODUCT_BUNDLE_BREAKDOWN_IN_RECEIPT, FALSE, TOGGLE,
                    strip(SETTING_PRODUCT_SHOW_PRODUCT_BUNDLE_BREAKDOWN_IN_RECEIPT), PRODUCT,
                    "DEVRAIT INDIQUER LA RÉPARTITION DES PRODUITS GROUPÉS DANS LE REÇU DU CLIENT")
            ),

            new SettingProduct(new SettingObj(SETTING_PRODUCT_ALLOW_TO_SELL_BUNDLED_PRODUCT_ALONE, FALSE, TOGGLE,
                    strip(SETTING_PRODUCT_ALLOW_TO_SELL_BUNDLED_PRODUCT_ALONE), PRODUCT,
                    "DEVRAIT PERMETTRE LA VENTE INDIVIDUELLE DES PRODUITS GROUPÉS")
            )

    );

    // sale
    public static final List<SettingSale> SETTING_SALES = of(
            new SettingSale(new SettingObj(SETTING_SALES_ENABLE_FLEXIBLE_SALE_PRICE, FALSE, TOGGLE,
                    strip(SETTING_SALES_ENABLE_FLEXIBLE_SALE_PRICE), SALES,
                    "PERMETTRE DES PRIX DE VENTE FLEXIBLES POUR LES PRODUITS AVEC PLUSIEURS ÉTIQUETTES DE PRIX")
            ),

            new SettingSale(new SettingObj(SETTING_SALES_ENFORCE_CUSTOMER_ON_SALES_CHECKOUT, FALSE, TOGGLE,
                    strip(SETTING_SALES_ENFORCE_CUSTOMER_ON_SALES_CHECKOUT), SALES,
                    "EN MAGASIN, FORCEZ L'UTILISATEUR À RECHERCHER OU AJOUTER UN CLIENT AVANT D'ENREGISTRER LE PAIEMENT DE LA TRANSACTION")
            )
    );

    static {
        SETTING_STOCKS = of(
                new SettingStock(new SettingObj(SETTING_STOCK_ENABLE_STOCK, FALSE, TOGGLE,
                        strip(SETTING_STOCK_ENABLE_STOCK), STOCK)
                ),
                new SettingStock(new SettingObj(SETTING_STOCK_BATCH_PREFIX_VALUE, STOCK_PREFIX_DEFAULT, INPUT,
                        strip(SETTING_STOCK_BATCH_PREFIX_VALUE), STOCK)
                ),
                new SettingStock(new SettingObj(SETTING_STOCK_SHOW_STOCK_COUNT, FALSE, TOGGLE,
                        strip(SETTING_STOCK_SHOW_STOCK_COUNT), STOCK)
                ),
                new SettingStock(new SettingObj(SETTING_STOCK_SHOW_OUT_OF_STOCK_ITEM, FALSE, TOGGLE,
                        strip(SETTING_STOCK_SHOW_OUT_OF_STOCK_ITEM), STOCK)
                ),
                new SettingStock(new SettingObj(SETTING_STOCK_SHOW_LOW_INVENTORY_WARNING, FALSE, TOGGLE,
                        strip(SETTING_STOCK_SHOW_LOW_INVENTORY_WARNING), STOCK)
                ),
                new SettingStock(new SettingObj(SETTING_STOCK_SHOW_DAMAGED_STOCK_ITEM, FALSE, TOGGLE,
                        strip(SETTING_STOCK_SHOW_DAMAGED_STOCK_ITEM), STOCK)
                )
        );
    }

    private static SettingOption options(String label, String value) {
        return new SettingOption(label, value);
    }

    private static String strip(String input) {
        String[] words = input.split("_");
        return String.join(" ", Arrays.copyOfRange(words, 1, words.length));
    }
}