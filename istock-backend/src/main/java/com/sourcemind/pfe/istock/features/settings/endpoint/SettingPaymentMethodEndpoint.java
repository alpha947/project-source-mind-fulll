package com.sourcemind.pfe.istock.features.settings.endpoint;

import com.sourcemind.pfe.istock.features.settings.data.dto.PaymentMethodRequest;
import com.sourcemind.pfe.istock.features.settings.data.interactor.settings_payment_method.ISettingPaymentMethodInteractor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static com.sourcemind.pfe.istock.core.constants.Global.API_PREFIX;

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

@RestController
@RequestMapping(value = API_PREFIX + "/setting-payment-method")
@RequiredArgsConstructor
public class SettingPaymentMethodEndpoint {

    private final ISettingPaymentMethodInteractor interactor;

    @GetMapping("by-name")
    public ResponseEntity<Optional<PaymentMethodRequest>> getByName(@RequestParam() String name) {
        return this.interactor.getByName(name);
    }


    @GetMapping("by-id")
    public ResponseEntity<Optional<PaymentMethodRequest>> getById(@RequestParam() Long id) {
        return this.interactor.getById(id);
    }


    @GetMapping(value = "all")
    public ResponseEntity<List<PaymentMethodRequest>> getAll() {
        return interactor.all();
    }


}