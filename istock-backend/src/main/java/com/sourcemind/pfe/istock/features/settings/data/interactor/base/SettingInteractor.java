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

package com.sourcemind.pfe.istock.features.settings.data.interactor.base;

import com.sourcemind.pfe.istock.core.annotations.Interactor;
import com.sourcemind.pfe.istock.features.settings.data.dto.SettingRequest;
import com.sourcemind.pfe.istock.features.settings.domain.enums.SettingModule;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Interactor
@RequiredArgsConstructor
public class SettingInteractor implements ISettingBaseInteractor {

    private final ApplicationContext context;

    /**
     * This method is used to retrieve a specific SettingRequest object based on the given key and module.
     * <p>
     * It uses the SettingModule to get the ISettingBaseInteractor implementation from the ApplicationContext.
     *
     * @param key    the key of the SettingRequest object to be retrieved.
     * @param module the module of the SettingRequest object.
     * @return a ResponseEntity object containing the retrieved SettingRequest object.
     */
    @Override
    public ResponseEntity<SettingRequest> get(String key, SettingModule module) {
        ISettingBaseInteractor interactor = module.interactor(context);
        return interactor.get(key);
    }

    /**
     * This method is used to retrieve a specific SettingRequest object based on the given key.
     *
     * @param key the key of the SettingRequest object to be retrieved.
     * @return a ResponseEntity object containing the retrieved SettingRequest object.
     */
    @Override
    public ResponseEntity<SettingRequest> get(String key) {
        return null;
    }

    /**
     * This method is used to retrieve all SettingRequest objects.
     *
     * @return a ResponseEntity object containing a list of all SettingRequest objects.
     */
    @Override
    public ResponseEntity<List<SettingRequest>> getAll() {
        return null;
    }


    /**
     * This method is used to update a SettingRequest object.
     *
     * @param dto the SettingRequest object to be updated.
     * @return a ResponseEntity object indicating the success or failure of the update operation.
     */
    @Override
    public ResponseEntity<Boolean> update(SettingRequest dto) {
        ISettingBaseInteractor interactor = dto.getSettingModule().interactor(context);
        return interactor.update(dto);
    }

    /**
     * This method is used to update multiple SettingRequest objects.
     *
     * @param list the list of SettingRequest objects to be updated.
     * @return a ResponseEntity object indicating the success or failure of the update operation.
     */
    @Override
    public ResponseEntity<Boolean> updateAll(List<SettingRequest> list) {
        return null;
    }
}
