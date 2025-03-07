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
package com.sourcemind.pfe.istock.core.commandrunner.seeds;

import com.sourcemind.pfe.istock.features.authentication.domain.entity.Permission;

import java.util.List;

import static com.sourcemind.pfe.istock.core.constants.ModulePermissions.*;
import static com.sourcemind.pfe.istock.features.authentication.domain.enums.AppModuleEnum.*;

public class PermissionSeeds {


    public static final List<Permission> AUTH_PERMISSIONS = List.of(
            new Permission(AUTHENTICATION_ACCESS_PAGE_MANAGE_ACCOUNT, AUTHENTICATION)
    );

    public static final List<Permission> COMPANY_PERMISSIONS = List.of(
            new Permission(COMPANY_BASIC_ACCESS_PAGE_COMPANY_BASIC, COMPANY),
            new Permission(COMPANY_BASIC_ACCESS_ACTION_COMPANY_BASIC_UPDATE, COMPANY),
            new Permission(COMPANY_TAX_ACCESS_PAGE_TAX_SETUP, COMPANY),
            new Permission(COMPANY_TAX_ACCESS_ACTION_TAX_SETUP_ADD, COMPANY),
            new Permission(COMPANY_TAX_ACCESS_ACTION_TAX_SETUP_UPDATE, COMPANY),
            new Permission(COMPANY_TAX_ACCESS_ACTION_TAX_SETUP_LIST, COMPANY),
            new Permission(COMPANY_PAYMENT_OPTION_ACCESS_PAGE_PAYMENT_OPTION, COMPANY),
            new Permission(COMPANY_PAYMENT_OPTION_ACCESS_ACTION_PAYMENT_OPTION_ADD, COMPANY),
            new Permission(COMPANY_PAYMENT_OPTION_ACCESS_ACTION_PAYMENT_OPTION_UPDATE, COMPANY),
            new Permission(COMPANY_PAYMENT_OPTION_ACCESS_ACTION_PAYMENT_OPTION_LIST, COMPANY),
            new Permission(COMPANY_LOCATION_ACCESS_PAGE_LOCATION, COMPANY),
            new Permission(COMPANY_LOCATION_ACCESS_ACTION_LOCATION_ADD, COMPANY),
            new Permission(COMPANY_LOCATION_ACCESS_ACTION_LOCATION_UPDATE, COMPANY),
            new Permission(COMPANY_LOCATION_ACCESS_ACTION_LOCATION_LIST, COMPANY),
            new Permission(COMPANY_EXPENSES_ACCESS_PAGE_EXPENSES, COMPANY),
            new Permission(COMPANY_EXPENSES_ACCESS_ACTION_EXPENSES_ADD, COMPANY),
            new Permission(COMPANY_EXPENSES_ACCESS_ACTION_EXPENSES_SEARCH, COMPANY),
            new Permission(COMPANY_EXPENSES_ACCESS_ACTION_EXPENSES_UPLOAD, COMPANY),
            new Permission(COMPANY_EXPENSES_ACCESS_ACTION_EXPENSES_UPDATE, COMPANY),
            new Permission(COMPANY_ROLE_ACCESS_PAGE_ROLE, COMPANY),
            new Permission(COMPANY_ROLE_ACCESS_ACTION_ROLE_ADD, COMPANY),
            new Permission(COMPANY_ROLE_ACCESS_ACTION_ROLE_UPDATE, COMPANY),
            new Permission(COMPANY_ROLE_ACCESS_ACTION_ROLE_LIST, COMPANY),
            new Permission(COMPANY_UNIT_OF_MEASURE_ACCESS_PAGE, COMPANY),
            new Permission(COMPANY_UNIT_OF_MEASURE_ACCESS_ACTION_ADD, COMPANY),
            new Permission(COMPANY_UNIT_OF_MEASURE_ACCESS_ACTION_UPDATE, COMPANY),
            new Permission(COMPANY_UNIT_OF_MEASURE_ACCESS_ACTION_LIST, COMPANY),
            new Permission(COMPANY_PRODUCT_STATUS_ACCESS_PAGE, COMPANY),
            new Permission(COMPANY_PRODUCT_STATUS_ACCESS_ACTION_ADD, COMPANY),
            new Permission(COMPANY_PRODUCT_STATUS_ACCESS_ACTION_UPDATE, COMPANY),
            new Permission(COMPANY_PRODUCT_STATUS_ACCESS_ACTION_LIST, COMPANY)

    );

    public static final List<Permission> PEOPLE_PERMISSION = List.of(
            new Permission(COMPANY_CUSTOMER_ACCESS_PAGE_CUSTOMER, PEOPLE),
            new Permission(COMPANY_CUSTOMER_ACCESS_ACTION_CUSTOMER_ADD, PEOPLE),
            new Permission(COMPANY_CUSTOMER_ACCESS_ACTION_CUSTOMER_UPDATE, PEOPLE),
            new Permission(COMPANY_CUSTOMER_ACCESS_ACTION_CUSTOMER_LIST, PEOPLE),
            new Permission(COMPANY_CUSTOMER_ACCESS_CUSTOMER_SEARCH, PEOPLE),

            new Permission(COMPANY_EMPLOYEE_ACCESS_PAGE_EMPLOYEE, PEOPLE),
            new Permission(COMPANY_EMPLOYEE_ACCESS_ACTION_EMPLOYEE_ADD, PEOPLE),
            new Permission(COMPANY_EMPLOYEE_ACCESS_ACTION_EMPLOYEE_UPDATE, PEOPLE),
            new Permission(COMPANY_EMPLOYEE_ACCESS_ACTION_EMPLOYEE_LIST, PEOPLE),
            new Permission(COMPANY_EMPLOYEE_ACCESS_EMPLOYEE_SEARCH, PEOPLE),

            new Permission(COMPANY_SUPPLIER_ACCESS_PAGE_SUPPLIER, PEOPLE),
            new Permission(COMPANY_SUPPLIER_ACCESS_ACTION_SUPPLIER_ADD, PEOPLE),
            new Permission(COMPANY_SUPPLIER_ACCESS_ACTION_SUPPLIER_UPDATE, PEOPLE),
            new Permission(COMPANY_SUPPLIER_ACCESS_ACTION_SUPPLIER_LIST, PEOPLE),
            new Permission(COMPANY_SUPPLIER_ACCESS_SUPPLIER_SEARCH, PEOPLE)
    );


    public static final List<Permission> PAYWALL_PERMISSIONS = List.of(
            new Permission(PAYWALL_ACCESS_PAGE_PAYWALL_PLAN, SUBSCRIPTION),
            new Permission(PAYWALL_ACCESS_PAGE_PAYWALL_PAYMENTS, SUBSCRIPTION),
            new Permission(PAYWALL_ACCESS_PAGE_PAYWALL_SETTINGS, SUBSCRIPTION),
            new Permission(PAYWALL_ACCESS_PAGE_PAYWALL_BILLING, SUBSCRIPTION),
            new Permission(PAYWALL_ACCESS_PAGE_PAYWALL_NOTIFICATION, SUBSCRIPTION)
    );
    public static final List<Permission> PRODUCT_PERMISSIONS = List.of(
            new Permission(PRODUCT_ACCESS_PAGE_PRODUCT, PRODUCT),
            new Permission(PRODUCT_ACCESS_ACTION_PRODUCT_SEARCH, PRODUCT),
            new Permission(PRODUCT_ACCESS_ACTION_PRODUCT_ADD, PRODUCT),
            new Permission(PRODUCT_ACCESS_ACTION_PRODUCT_UPDATE, PRODUCT),
            new Permission(PRODUCT_ACCESS_ACTION_PRODUCT_UPLOAD, PRODUCT),
            new Permission(PRODUCT_CATEGORY_ACCESS_PAGE_PRODUCT_CATEGORY, PRODUCT),
            new Permission(PRODUCT_CATEGORY_ACCESS_ACTION_PRODUCT_CATEGORY_SEARCH, PRODUCT),
            new Permission(PRODUCT_CATEGORY_ACCESS_ACTION_PRODUCT_CATEGORY_ADD, PRODUCT),
            new Permission(PRODUCT_CATEGORY_ACCESS_ACTION_PRODUCT_CATEGORY_UPDATE, PRODUCT),
            new Permission(PRODUCT_CATEGORY_ACCESS_ACTION_PRODUCT_CATEGORY_UPLOAD, PRODUCT)
    );
    public static final List<Permission> REPORT_PERMISSIONS = List.of(
            new Permission(REPORT_ACCESS_PAGE_REPORT_SALES, REPORT),
            new Permission(REPORT_ACCESS_PAGE_REPORT_EXPENSES, REPORT),
            new Permission(REPORT_ACCESS_PAGE_REPORT_EMPLOYEE, REPORT),
            new Permission(REPORT_ACCESS_PAGE_REPORT_CUSTOMER, REPORT),
            new Permission(REPORT_ACCESS_PAGE_REPORT_STOCK, REPORT)
    );
    public static final List<Permission> SALE_PERMISSIONS = List.of(
            new Permission(SALE_ACCESS_PAGE_SALE_STORE_FRONT, SALE),
            new Permission(SALE_ACCESS_ACTION_SALE_BILL_PAYMENT, SALE),
            new Permission(SALE_ACCESS_ACTION_SALE_SAVE_ORDER, SALE),
            new Permission(SALE_ACCESS_ACTION_SALE_PRINT_BILL_RECEIPT, SALE),
            new Permission(SALE_ACCESS_PAGE_SALE_REFUND, SALE),
            new Permission(SALE_ACCESS_PAGE_SALE_DISCOUNT, SALE),
            new Permission(SALE_ACCESS_PAGE_SALE_SHIFT_PER_DAY, SALE),
            new Permission(SALE_ACCESS_PAGE_SALE_REPRINT_RECEIPT, SALE)
    );
    public static final List<Permission> SETTING_PERMISSIONS = List.of(
            new Permission(SETTING_ACCESS_PAGE_SETTING_DASHBOARD, SETTING),
            new Permission(SETTING_ACCESS_PAGE_SETTING_EXPENSES, SETTING),
            new Permission(SETTING_ACCESS_PAGE_SETTING_SALES, SETTING),
            new Permission(SETTING_ACCESS_PAGE_SETTING_PEOPLE, SETTING),
            new Permission(SETTING_ACCESS_PAGE_SETTING_STOCK, SETTING),
            new Permission(SETTING_ACCESS_PAGE_SETTING_PRODUCT, SETTING)
    );
    public static final List<Permission> STOCK_PERMISSIONS = List.of(
            new Permission(STOCK_ACCESS_PAGE_STOCK_MANAGE, STOCK),
            new Permission(STOCK_ACCESS_ACTION_STOCK_SEARCH, STOCK),
            new Permission(STOCK_ACCESS_ACTION_STOCK_ADD, STOCK),
            new Permission(STOCK_ACCESS_ACTION_STOCK_UPDATE, STOCK),
            new Permission(STOCK_ACCESS_ACTION_STOCK_UPLOAD, STOCK),
            new Permission(STOCK_COUNT_ACCESS_PAGE_COUNT_STOCK, STOCK),
            new Permission(STOCK_COUNT_ACCESS_ACTION_SEARCH_COUNT_STOCK, STOCK),
            new Permission(STOCK_COUNT_ACCESS_ACTION_EXPORT_COUNT_STOCK, STOCK),
            new Permission(STOCK_LOW_STOCK_ACCESS_PAGE_LOW_STOCK, STOCK),
            new Permission(STOCK_LOW_STOCK_ACCESS_ACTION_LOW_STOCK_SEARCH, STOCK),
            new Permission(STOCK_RECONCILE_ACCESS_PAGE_RECONCILE_STOCK, STOCK),
            new Permission(STOCK_RECORD_STOCK_BALANCE_ACCESS_PAGE_RECORD_STOCK_BALANCE, STOCK),
            new Permission(STOCK_RECORD_STOCK_BALANCE_ACCESS_ACTION_RECORD_STOCK_BALANCE_SEARCH, STOCK),
            new Permission(STOCK_RECORD_STOCK_BALANCE_ACCESS_ACTION_RECORD_STOCK_BALANCE_ADD, STOCK),
            new Permission(STOCK_RECORD_STOCK_BALANCE_ACCESS_ACTION_RECORD_STOCK_BALANCE_UPLOAD, STOCK),
            new Permission(STOCK_RECORD_STOCK_BALANCE_ACCESS_ACTION_RECORD_STOCK_BALANCE_UPDATE, STOCK),
            new Permission(STOCK_RECORD_DAMAGED_GOODS_ACCESS_PAGE_RECORD_DAMAGED_GOODS, STOCK),
            new Permission(STOCK_RECORD_DAMAGED_GOODS_ACCESS_ACTION_RECORD_DAMAGED_GOODS_SEARCH, STOCK),
            new Permission(STOCK_RECORD_DAMAGED_GOODS_ACCESS_ACTION_RECORD_DAMAGED_GOODS_ADD, STOCK),
            new Permission(STOCK_RECORD_DAMAGED_GOODS_ACCESS_ACTION_RECORD_DAMAGED_GOODS_UPLOAD, STOCK),
            new Permission(STOCK_MOVE_ITEM_ACCESS_PAGE_MOVE_STOCK_ITEM, STOCK),
            new Permission(STOCK_MOVE_ITEM_ACCESS_ACTION_MOVE_STOCK_ITEM_ADD, STOCK),
            new Permission(STOCK_MOVE_ITEM_ACCESS_ACTION_MOVE_STOCK_ITEM_SEARCH, STOCK),
            new Permission(STOCK_MOVE_ITEM_ACCESS_ACTION_MOVE_STOCK_ITEM_UPLOAD, STOCK)

    );
}
