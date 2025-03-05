import {Menu} from '@delon/theme';
import {MenuRoute} from './menu.payload';

export const MENU_BAG: Menu[] = [
    {
        text: 'Principal',
        group: true,
        children: [

            {
                text: 'Tableau de bord',
                link: MenuRoute.DASHBOARD.Home,
                icon: {type: 'icon', value: 'appstore'},
                children: [
                    {text: 'Accueil', link: MenuRoute.DASHBOARD.Home}
                ]
            },

            {
                text: 'Produits',
                icon: {type: 'icon', value: 'shopping-cart'},
                children: [
                    {
                        text: 'Catégories',
                        link: MenuRoute.PRODUCT.Categories
                    },

                    {
                        text: 'Produits',
                        link: MenuRoute.PRODUCT.Products
                    }
                ]
            },

            {
                text: 'Ventes',
                icon: {type: 'icon', value: 'credit-card'},
                children: [
                    {text: 'Vente', link: MenuRoute.SALE.Sale},
                    {text: 'Commande', link: MenuRoute.SALE.Order},
                    {text: 'Remboursement', link: MenuRoute.SALE.Refund},
                    {text: 'Rapport de service', link: MenuRoute.SALE.Shift},
                    {text: 'Réimprimer le reçu', link: MenuRoute.SALE.RePrint}
                ]
            },

            {
                text: 'Stock',
                icon: {type: 'icon', value: 'appstore-add'},
                children: [
                    {text: 'Gérer le stock', link: MenuRoute.STOCK.Manage_Stock},
                    {text: 'Compter le stock', link: MenuRoute.STOCK.Count_Stock},
                    {text: 'Voir le stock faible', link: MenuRoute.STOCK.View_Low_Stock},
                    {text: 'Réconcilier le stock', link: MenuRoute.STOCK.Reconcile_Stock},
                    {text: 'Enregistrer le solde du stock', link: MenuRoute.STOCK.Record_Stock_Balance},
                    {text: 'Enregistrer les stocks endommagés', link: MenuRoute.STOCK.Record_Damaged_Stock},
                    {text: 'Déplacer des articles en stock', link: MenuRoute.STOCK.Move_Stock_Items}
                ]
            },

            {
                text: 'Entreprise',
                icon: {type: 'icon', value: 'shop'},
                children: [
                    {text: 'Configuration de base', link: MenuRoute.COMPANY.Basic_Setup},
                    {text: 'Configuration des taxes', link: MenuRoute.COMPANY.Tax_Setup},
                    {text: 'Options de paiement', link: MenuRoute.COMPANY.Payment_Options},
                    {
                        text: 'Configuration des personnes',
                        link: '/company/people',
                        children: [
                            {text: 'Clients', link: MenuRoute.PEOPLE.Customers},
                            {text: 'Employés', link: MenuRoute.PEOPLE.Employees},
                            {text: 'Fournisseurs', link: MenuRoute.PEOPLE.Suppliers}
                        ]
                    },
                    {text: 'Configuration des emplacements', link: MenuRoute.COMPANY.Location_Setup},
                    {text: 'Gestion des dépenses', link: MenuRoute.COMPANY.Expenses_Setup},
                    {text: 'Configuration des rôles', link: MenuRoute.COMPANY.Role_Setup}
                ]
            },

            {
                text: 'Rapports',
                icon: {type: 'icon', value: 'file-pdf'},
                children: [
                    {text: 'Ventes', link: MenuRoute.REPORT.Sales},
                    {text: 'Dépenses', link: MenuRoute.REPORT.Expense},
                    {text: 'Employés', link: MenuRoute.REPORT.Employee},
                    {text: 'Clients', link: MenuRoute.REPORT.Customer},
                    {text: 'Stock', link: MenuRoute.REPORT.Stock}
                ]
            },

            {
                text: 'Paramètres',
                icon: {type: 'icon', value: 'setting'},
                children: [
                    {text: 'Tableau de bord', link: MenuRoute.SETTING.Dashboard},
                    {text: 'Dépenses', link: MenuRoute.SETTING.Expenses},
                    {text: 'Ventes', link: MenuRoute.SETTING.Sales},
                    {text: 'Personnes', link: MenuRoute.SETTING.People},
                    {text: 'Stock', link: MenuRoute.SETTING.Stock},
                    {text: 'Produit', link: MenuRoute.SETTING.Product}
                ]
            },

            {
                text: 'Abonnement',
                icon: {type: 'icon', value: 'wallet'},
                children: [
                    {text: 'Plan', link: MenuRoute.SUBSCRIPTION.Plan},
                    {text: 'Paiements', link: MenuRoute.SUBSCRIPTION.Payments},
                    {text: 'Paramètres', link: MenuRoute.SUBSCRIPTION.Settings},
                    {text: 'Facturation', link: MenuRoute.SUBSCRIPTION.Billing},
                    {text: 'Notification', link: MenuRoute.SUBSCRIPTION.Notification}
                ]
            }

        ]
    }
];
