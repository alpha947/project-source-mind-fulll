package com.sourcemind.pfe.istock.core.commandrunner.seeds;

import com.sourcemind.pfe.istock.features.company.domain.entity.*;

import java.util.List;

import static com.sourcemind.pfe.istock.core.constants.CompanyDetailConstant.*;

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
public class CompanySeeds {

    public static final String EMPTY_STRING = "";

    // company expenses categories
    public static final List<CompanyExpensesCategory> COMPANY_EXPENSES_CATEGORIES = List.of(
        new CompanyExpensesCategory("ALIMENTATION", "DÉPENSES LIÉES À L'ALIMENTATION"),
        new CompanyExpensesCategory("TRANSPORT", "DÉPENSES LIÉES AU TRANSPORT"),
        new CompanyExpensesCategory("CARBURANT", "DÉPENSES EN CARBURANT POUR GÉNÉRATEUR, VOITURE, ETC"),
        new CompanyExpensesCategory("ACHAT", "DÉPENSES POUR ACHATS D'ARTICLES, FOURNIR FACTURE OU PREUVE D'ACHAT"),
        new CompanyExpensesCategory("MAINTENANCE", "COÛTS DE MAINTENANCE ET ENTRETIEN"),
        new CompanyExpensesCategory("LOYER", "DÉPENSES LIÉES À LA LOCATION DE LOCAUX"),
        new CompanyExpensesCategory("ÉLECTRICITÉ", "FACTURES D'ÉLECTRICITÉ"),
        new CompanyExpensesCategory("EAU", "FACTURES D'EAU"),
        new CompanyExpensesCategory("INTERNET", "ABONNEMENT ET SERVICES INTERNET"),
        new CompanyExpensesCategory("TÉLÉPHONE", "FRAIS DE TÉLÉPHONIE"),
        new CompanyExpensesCategory("FOURNITURES_BUREAU", "PAPETERIE ET FOURNITURES DE BUREAU"),
        new CompanyExpensesCategory("SALAIRES", "PAIEMENTS DES SALAIRES DES EMPLOYÉS"),
        new CompanyExpensesCategory("IMPÔTS", "PAIEMENTS D'IMPÔTS ET TAXES"),
        new CompanyExpensesCategory("ASSURANCES", "PRIMES D'ASSURANCE"),
        new CompanyExpensesCategory("MARKETING", "DÉPENSES PUBLICITAIRES ET PROMOTIONNELLES"),
        new CompanyExpensesCategory("FORMATION", "COÛTS DE FORMATION DU PERSONNEL"),
        new CompanyExpensesCategory("EQUIPEMENT", "ACHAT D'ÉQUIPEMENTS ET MATÉRIELS"),
        new CompanyExpensesCategory("LOGICIELS", "LICENCES ET ABONNEMENTS LOGICIELS"),
        new CompanyExpensesCategory("FRAIS_BANCAIRES", "FRAIS DE SERVICES BANCAIRES"),
        new CompanyExpensesCategory("DÉPLACEMENTS", "FRAIS DE DÉPLACEMENT PROFESSIONNEL"),
        new CompanyExpensesCategory("RÉPARATIONS", "RÉPARATIONS D'ÉQUIPEMENTS ET LOCAUX"),
        new CompanyExpensesCategory("ÉVÉNEMENTS", "ORGANISATION D'ÉVÉNEMENTS D'ENTREPRISE"),
        new CompanyExpensesCategory("CONSEIL", "HONORAIRES DE CONSULTANTS ET EXPERTS"),
        new CompanyExpensesCategory("DONS", "CONTRIBUTIONS CARITATIVES ET DONS"),
        new CompanyExpensesCategory("DIVERS", "AUTRES DÉPENSES NON CATÉGORISÉES")
    );

    public static final List<CompanyBusinessCategory> COMPANY_BUSINESS_CATEGORIES = List.of( 
        new CompanyBusinessCategory("BoutiqueDe Vêtements"),
        new CompanyBusinessCategory("Pharmacie"),
        new CompanyBusinessCategory("QuincaillerieEtBricolage"),
        new CompanyBusinessCategory("Bijouterie"),
        new CompanyBusinessCategory("CentreDeFitness"),
        new CompanyBusinessCategory("MagasinDÉlectronique"),
        new CompanyBusinessCategory("Librairie"),
        new CompanyBusinessCategory("CaféEtSalon"),
        new CompanyBusinessCategory("AnimalerieEtAccessoires"),
        new CompanyBusinessCategory("MagasinDeJouets"),
        new CompanyBusinessCategory("MagasinDeMusique"),
        new CompanyBusinessCategory("DécorationIntérieure"),
        new CompanyBusinessCategory("JardineriePépinière"),
        new CompanyBusinessCategory("GarageAutomobile"),
        new CompanyBusinessCategory("CliniqueDentaire"),
        new CompanyBusinessCategory("BoutiqueDesCadeaux"),
        new CompanyBusinessCategory("MagasinDePneus"),
        new CompanyBusinessCategory("Autre")
    );

    public static final List<CompanyBasicDetail> COMPANY_BASIC_DETAILS = List.of(
            new CompanyBasicDetail(COMPANY_BUSINESS_NAME, EMPTY_STRING),
            new CompanyBasicDetail(COMPANY_BUSINESS_CATEGORY, EMPTY_STRING),
            new CompanyBasicDetail(COMPANY_BUSINESS_EMPLOYEE_SIZE, EMPTY_STRING),
            new CompanyBasicDetail(COMPANY_BUSINESS_NUMBER_OF_YEARS_OF_OPERATION, EMPTY_STRING),
            new CompanyBasicDetail(COMPANY_BUSINESS_NUMBER_OF_BRANCH, EMPTY_STRING),
            new CompanyBasicDetail(COMPANY_BUSINESS_ADDRESS, EMPTY_STRING)
    );

    public static final List<CompanyAdministratorDetail> COMPANY_ADMINISTRATOR_DETAILS = List.of(
            new CompanyAdministratorDetail(COMPANY_PROFILE_NAME, EMPTY_STRING),
            new CompanyAdministratorDetail(COMPANY_PROFILE_PHONE, EMPTY_STRING),
            new CompanyAdministratorDetail(COMPANY_PROFILE_EMAIL, EMPTY_STRING),
            new CompanyAdministratorDetail(COMPANY_PROFILE_POSITION, EMPTY_STRING)
    );

    public static final List<CompanyRegionDetail> COMPANY_LOCALE_DETAILS = List.of(
            new CompanyRegionDetail(COMPANY_REGION_CURRENCY, EMPTY_STRING),
            new CompanyRegionDetail(COMPANY_REGION_LANGUAGE, EMPTY_STRING),
            new CompanyRegionDetail(COMPANY_REGION_TIME_ZONE, EMPTY_STRING)
    );

}