package com.sourcemind.pfe.istock.configuration.configurer;

import com.sourcemind.pfe.istock.configuration.converter.LocalDateStringConverter;
import org.modelmapper.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

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
public class ModelMapperConfig {

    Provider<LocalDate> localDateProvider = new AbstractProvider<LocalDate>() {
        @Override
        public LocalDate get() {
            return LocalDate.now();
        }
    };

    Converter<String, LocalDate> toStringDate = new AbstractConverter<String, LocalDate>() {
        @Override
        protected LocalDate convert(String source) {
            return new LocalDateStringConverter().convert(source);
        }
    };


    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setSkipNullEnabled(true);
        mapper.getConfiguration().setAmbiguityIgnored(true);

        mapper.createTypeMap(String.class, LocalDate.class);
        mapper.addConverter(toStringDate);
        mapper.getTypeMap(String.class, LocalDate.class).setProvider(localDateProvider);

        return mapper;
    }
}