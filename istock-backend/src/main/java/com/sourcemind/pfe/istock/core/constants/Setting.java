package com.sourcemind.pfe.istock.core.constants;

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
public class Setting {
    public final static String STOCK_PREFIX_DEFAULT = "STK_";
    public final static Integer STOCK_CODE_DEFAULT_START = 100;

    public static final String DEFAULT_SYS_ROLE = "system_rol";

    public static final String TRUE = "true";

    // backup and restore
    public static final String SETTING_BACKUP_ENABLE_AUTO_BACK_UP = "BACKUP_ENABLE_AUTO_BACKUP";

    // dashboard
    public static final String SETTING_DASHBOARD_SHOW_EMPLOYEE_PERFORMANCE = "DASHBOARD_SHOW_EMPLOYEE_PERFORMANCE";
    public static final String SETTING_DASHBOARD_SHOW_PRODUCT_PERFORMANCE = "DASHBOARD_SHOW_PRODUCT_PERFORMANCE";

    // expenses
    public static final String SETTING_EXPENSES_ENABLE_EXPENSES_APPROVAL = "EXPENSES_ENABLE_EXPENSES_APPROVAL";

    // tax
    public static final String SETTING_TAX_ENABLE_TAX = "TAX_ENABLE_TAX";
    public static final String SETTING_TAX_PERCENT_VALUE = "TAX_TAX_PERCENT_VALUE";

    // stock
    public static final String SETTING_STOCK_ENABLE_STOCK = "STOCK_ENABLE_STOCK";
    public static final String SETTING_STOCK_BATCH_PREFIX_VALUE = "STOCK_STOCK_BATCH_PREFIX_VALUE";
    public static final String SETTING_STOCK_SHOW_STOCK_COUNT = "STOCK_SHOW_TOTAL_STOCK_COUNT";
    public static final String SETTING_STOCK_SHOW_OUT_OF_STOCK_ITEM = "STOCK_SHOW_OUT_OF_STOCK_ITEM";
    public static final String SETTING_STOCK_SHOW_LOW_INVENTORY_WARNING = "STOCK_SHOW_LOW_INVENTORY_WARNING";
    public static final String SETTING_STOCK_SHOW_DAMAGED_STOCK_ITEM = "STOCK_SHOW_DAMAGED_STOCK_ITEM";
    public static final String SETTING_STOCK_ALLOW_MOVE_STOCK_ITEM = "STOCK_ALLOW_MOVE_STOCK_ITEM";

    // people
    public static final String SETTING_PEOPLE_SHOW_EMPLOYEE_SALES_PERFORMANCE = "PEOPLE_SHOW_EMPLOYEE_SALES_PERFORMANCE";
    public static final String SETTING_PEOPLE_SHOW_EMPLOYEE_SHIFT = "PEOPLE_SHOW_EMPLOYEE_SHIFT_HOURS";
    public static final String SETTING_PEOPLE_SHOW_EMPLOYEE_PROFIT_PERFORMANCE = "PEOPLE_SHOW_EMPLOYEE_OVERALL_PROFIT_PERFORMANCE";
    public static final String SETTING_PEOPLE_SHOW_TOTAL_CUSTOMER_STATS = "PEOPLE_SHOW_TOTAL_CUSTOMER_STATS";

    // product
    public static final String SETTING_PRODUCT_ENABLE_PRODUCT_BUNDLE = "PRODUCT_ENABLE_PRODUCT_BUNDLE";
    public static final String SETTING_PRODUCT_SHOW_PRODUCT_BUNDLE_BREAKDOWN_IN_RECEIPT = "PRODUCT_SHOW_PRODUCT_BUNDLE_BREAKDOWN_IN_RECEIPT";
    public static final String SETTING_PRODUCT_ALLOW_TO_SELL_BUNDLED_PRODUCT_ALONE = "PRODUCT_ALLOW_TO_SELL_BUNDLED_PRODUCT_ALONE";

    // sales
    public static final String SETTING_SALES_ENABLE_FLEXIBLE_SALE_PRICE = "SETTING_SALES_ENABLE_FLEXIBLE_SALE_PRICE";
    public static final String SETTING_SALES_ENFORCE_CUSTOMER_ON_SALES_CHECKOUT = "SETTING_SALES_ENFORCE_CUSTOMER_ON_SALES_CHECKOUT";


}