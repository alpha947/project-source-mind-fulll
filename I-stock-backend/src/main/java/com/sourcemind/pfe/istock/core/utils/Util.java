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

package com.sourcemind.pfe.istock.core.utils;

import com.sourcemind.pfe.istock.configuration.converter.LocalDateStringConverter;
import com.sourcemind.pfe.istock.core.constants.ReportConstant;
import org.apache.commons.lang3.RandomStringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

import static org.apache.commons.lang3.ObjectUtils.isNotEmpty;
import static org.springframework.util.ObjectUtils.isEmpty;

public class Util {

    public static LocalDate parseToLocalDate(String date) {
        LocalDateStringConverter converter = new LocalDateStringConverter();
        return converter.convert(date == null ? LocalDate.now().toString() : date);
    }

    public static LocalDateTime parseToLocalDateTime(String date) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return isEmpty(date) ? LocalDateTime.now() : LocalDateTime.parse(date, format);
    }

    public static String randomAlphanumeric(Integer count) {
        return RandomStringUtils.randomAlphanumeric(count);
    }

    public static String receiptSerial(Integer count) {
        return String.format("%s%s", ReportConstant.RECEIPT_PREFIX, randomNumeric(count));
    }

    public static String randomString(Integer count) {
        return RandomStringUtils.randomAlphabetic(count);
    }

    public static String randomNumeric(Integer count) {
        return RandomStringUtils.randomNumeric(count);
    }

    public static String formatDate(LocalDate date) {
        return isNotEmpty(date) ? date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)) : "";
    }

    public static String formatTime(LocalTime time) {
        return isNotEmpty(time) ? time.format(DateTimeFormatter.ofPattern("KK:mm:ss a", Locale.ENGLISH)) : "";
    }

    public static String formatAmount(Double amount) {
        return String.format("%,.2f", isNotEmpty(amount) ? amount : 0.0);
    }

    public static Boolean isProduction(String activeProfile) {
        return !isEmpty(activeProfile) && activeProfile.contains("prod");
    }

}
