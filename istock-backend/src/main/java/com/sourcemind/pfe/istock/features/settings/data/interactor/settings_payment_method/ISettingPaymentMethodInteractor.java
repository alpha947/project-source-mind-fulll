package com.sourcemind.pfe.istock.features.settings.data.interactor.settings_payment_method;

import com.sourcemind.pfe.istock.features.settings.data.dto.PaymentMethodRequest;
import com.sourcemind.pfe.istock.features.settings.data.interactor.base.ISettingBaseInteractor;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

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


public interface ISettingPaymentMethodInteractor extends ISettingBaseInteractor {

    ResponseEntity<Optional<PaymentMethodRequest>> getByName(String name);

    ResponseEntity<Optional<PaymentMethodRequest>> getById(Long id);

    ResponseEntity<List<PaymentMethodRequest>> all();

}