package com.sourcemind.pfe.istock.features.settings.domain.enums;

import com.sourcemind.pfe.istock.features.settings.data.interactor.base.ISettingBaseInteractor;
import com.sourcemind.pfe.istock.features.settings.data.interactor.setting_backup_restore.SettingBackupInteractor;
import com.sourcemind.pfe.istock.features.settings.data.interactor.setting_company.SettingCompanyInteractor;
import com.sourcemind.pfe.istock.features.settings.data.interactor.setting_dashboard.SettingDashboardInteractor;
import com.sourcemind.pfe.istock.features.settings.data.interactor.setting_expenses.SettingExpensesInteractor;
import com.sourcemind.pfe.istock.features.settings.data.interactor.setting_notification.SettingNotificationInteractor;
import com.sourcemind.pfe.istock.features.settings.data.interactor.setting_people.SettingPeopleInteractor;
import com.sourcemind.pfe.istock.features.settings.data.interactor.setting_product.SettingProductInteractor;
import com.sourcemind.pfe.istock.features.settings.data.interactor.setting_sale.SettingSaleInteractor;
import com.sourcemind.pfe.istock.features.settings.data.interactor.setting_stock.SettingStockInteractor;
import com.sourcemind.pfe.istock.features.settings.data.interactor.setting_tax.SettingTaxInteractor;
import com.sourcemind.pfe.istock.features.settings.data.interactor.settings_payment_method.SettingPaymentMethodInteractor;
import com.sourcemind.pfe.istock.features.settings.data.usecases_impl.*;
import com.sourcemind.pfe.istock.features.settings.domain.usecase.ISettingUsecase;
import org.springframework.context.ApplicationContext;

public enum SettingModule {

    BACKUP {
        public ISettingUsecase<?> usecase(ApplicationContext context) {
            return context.getBean(SettingBackupUsecase.class);
        }

        public ISettingBaseInteractor interactor(ApplicationContext context) {
            return context.getBean(SettingBackupInteractor.class);
        }
    },
    DASHBOARD {
        public ISettingUsecase<?> usecase(ApplicationContext context) {
            return context.getBean(SettingDashboardUsecase.class);
        }

        public ISettingBaseInteractor interactor(ApplicationContext context) {
            return context.getBean(SettingDashboardInteractor.class);
        }
    },
    EXPENSES {
        public ISettingUsecase<?> usecase(ApplicationContext context) {
            return context.getBean(SettingExpensesUsecase.class);
        }

        public ISettingBaseInteractor interactor(ApplicationContext context) {
            return context.getBean(SettingExpensesInteractor.class);
        }
    },
    NOTIFICATION {
        public ISettingUsecase<?> usecase(ApplicationContext context) {
            return context.getBean(SettingNotificationUsecase.class);
        }

        public ISettingBaseInteractor interactor(ApplicationContext context) {
            return context.getBean(SettingNotificationInteractor.class);
        }
    },
    PAYMENT_METHOD {
        public ISettingUsecase<?> usecase(ApplicationContext context) {
            return context.getBean(SettingPaymentMethodUsecase.class);
        }

        public ISettingBaseInteractor interactor(ApplicationContext context) {
            return context.getBean(SettingPaymentMethodInteractor.class);
        }
    },
    PEOPLE {
        public ISettingUsecase<?> usecase(ApplicationContext context) {
            return context.getBean(SettingPeopleUsecase.class);
        }

        public ISettingBaseInteractor interactor(ApplicationContext context) {
            return context.getBean(SettingPeopleInteractor.class);
        }
    },
    PRODUCT {
        public ISettingUsecase<?> usecase(ApplicationContext context) {
            return context.getBean(SettingProductUsecase.class);
        }

        public ISettingBaseInteractor interactor(ApplicationContext context) {
            return context.getBean(SettingProductInteractor.class);
        }
    },
    SALES {
        public ISettingUsecase<?> usecase(ApplicationContext context) {
            return context.getBean(SettingSaleUsecase.class);
        }

        public ISettingBaseInteractor interactor(ApplicationContext context) {
            return context.getBean(SettingSaleInteractor.class);
        }
    },
    STOCK {
        public ISettingUsecase<?> usecase(ApplicationContext context) {
            return context.getBean(SettingStockUsecase.class);
        }

        public ISettingBaseInteractor interactor(ApplicationContext context) {
            return context.getBean(SettingStockInteractor.class);
        }
    },
    TAX {
        public ISettingUsecase<?> usecase(ApplicationContext context) {
            return context.getBean(SettingTaxUsecase.class);
        }

        public ISettingBaseInteractor interactor(ApplicationContext context) {
            return context.getBean(SettingTaxInteractor.class);
        }
    },
    COMPANY {
        public ISettingUsecase<?> usecase(ApplicationContext context) {
            return null;
        }

        public ISettingBaseInteractor interactor(ApplicationContext context) {
            return context.getBean(SettingCompanyInteractor.class);
        }
    };


    public abstract ISettingUsecase<?> usecase(ApplicationContext context);

    public abstract <T> ISettingBaseInteractor interactor(ApplicationContext context);
}
