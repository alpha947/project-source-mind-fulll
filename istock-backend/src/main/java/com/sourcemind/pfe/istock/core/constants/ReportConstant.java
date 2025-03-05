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
 *//**
 * * ==========================================================
 * * Projet de fin d'études - SourceMind
 * *
 * * Développé par l'équipe Groupe 1 :
 * *  - Alpha Amadou DIALLO (https://github.com/alpha947)
 * *    Email : dialloalphaamadou947@gmail.com
 * *  - Kouloube KOLIE (https://github.com/kouloube)
 * *    Email : kouloubekolie@gmail.com
 * *  - Moussa CAMARA (https://github.com/usermoussa)
 * *    Email : moussaccamaraa@gmail.com
 * *  - Mohamed Mouctar KABA (https://github.com/Mokaba-lab)
 * *    Email : mocktarkba@gmail.com
 * *
 * * Ce projet Spring Boot a été conçu et développé
 * * pour démontrer nos compétences techniques et
 * * apporter une solution innovante.
 * * ==========================================================
 */

package com.sourcemind.pfe.istock.core.constants;

public class ReportConstant {
    public static final String EMPTY = "";
    public static final String WALK_IN = "Client de passage";
    public static final String SPACE = " ";
    public static final String DASHES = "---";
    public static final String RECEIPT_PREFIX = "RCP";
    public static final String NOT_AVAILABLE = "N/D"; // "Non disponible"
    public static final String SCRAP_ERROR = "Erreur à la ligne %s / cellule %s : ";
    public static final String CELL_EMPTY = "Aucune valeur fournie dans la cellule";
    public static final String PRD = "Produit";
    public static final String TOTAL_COUNT = "Compte total";
    public static final String SUCCESS_COUNT = "Compte des réussites";
    public static final String FAILED_COUNT = "Compte des échecs";
    public static final String STATS_COUNT = "Compte des statistiques";
    public static final String GENERIC_EXISTS = "%s avec le même %s existe déjà ( %s )";
    public static final String NO_CATEGORY_EXISTS = "Aucune catégorie de produit avec ce nom ( %s ) n'existe";
    public static final String ROW_EMPTY = "Aucune valeur fournie dans la ligne";
    public static final String DONT_EXIST = " n'existe pas dans nos enregistrements";
    public static final String RECEIPT_DISCLAIMER = "Tous les articles achetés sont non retournables, merci pour votre confiance !";
    public static final String RECEIPT_FOOTER = "";
    public static final String SALES_REPORT_TITLE = "Rapport quotidien de collecte des ventes";
    public static final String SALES_SUMMARIZED_REPORT_TITLE = "Rapport résumé de collecte des ventes";
    public static final String SALES_DETAILED_REPORT_TITLE = "Rapport détaillé de collecte des ventes";
    public static final String RECEIPT_NOT_FOUND = "Reçu non trouvé, détails fournis invalides";
    public static final String REPORT_FILE_NAME = "inline; filename=\"Rapport.pdf\"";
    public static final String RECEIPT_FILE_NAME = "inline; filename=\"Reçu.pdf\"";
    public static final String PDF_CONTENT_TYPE = "application/pdf; charset=UTF-8";
    public static final String UNEXPECTED_FILE_TYPE = "Type de fichier invalide fourni, le fichier doit être %s";
}
