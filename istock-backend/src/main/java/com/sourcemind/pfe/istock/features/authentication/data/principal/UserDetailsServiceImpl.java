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

package com.sourcemind.pfe.istock.features.authentication.data.principal;

import com.sourcemind.pfe.istock.features.authentication.data.repository.UserRepository;
import com.sourcemind.pfe.istock.features.authentication.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component()
public class UserDetailsServiceImpl implements UserDetailsService {

    private static final String NO_USER_FOUND = "No user found ";

    @Autowired
    private UserRepository usecase;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optional = this.usecase
                .findByUsernameEqualsIgnoreCase(username);
        return optional.map(UserPrincipalImpl::new)
                .orElseThrow(() -> new UsernameNotFoundException(NO_USER_FOUND + username));
    }

}
