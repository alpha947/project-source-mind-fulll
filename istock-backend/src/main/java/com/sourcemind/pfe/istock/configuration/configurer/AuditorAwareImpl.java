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


package com.sourcemind.pfe.istock.configuration.configurer;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

import static java.util.Optional.ofNullable;
import static org.springframework.security.core.context.SecurityContextHolder.getContext;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        String username = getContext().getAuthentication() != null ? getContext().getAuthentication().getName() : "";
        return ofNullable(username).filter(s -> !s.isEmpty());
    }

}
