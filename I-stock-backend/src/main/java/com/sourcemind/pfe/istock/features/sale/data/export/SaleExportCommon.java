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

package com.sourcemind.pfe.istock.features.sale.data.export;

import com.sourcemind.pfe.istock.features.company.domain.usecase.ICompanyAdministratorSetupUsecase;
import com.sourcemind.pfe.istock.features.company.domain.usecase.ICompanyBasicDetailUsecase;
import com.sourcemind.pfe.istock.features.company.domain.usecase.ICompanyRegionSetupUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Optional;

import static com.sourcemind.pfe.istock.core.constants.CompanyDetailConstant.*;
import static com.sourcemind.pfe.istock.core.constants.ReportConstant.RECEIPT_FOOTER;

@Component
@RequiredArgsConstructor
public class SaleExportCommon {

    public static final String EMPTY = "";
    private final ICompanyAdministratorSetupUsecase adminUsecase;
    private final ICompanyBasicDetailUsecase basicDetailUsecase;
    private final ICompanyRegionSetupUsecase regionSetupUsecase;

    public HashMap<String, Object> toMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("businessName", this.basicDetailUsecase.getValue(COMPANY_BUSINESS_NAME).orElse(EMPTY));
        map.put("businessAddress", this.basicDetailUsecase.getValue(COMPANY_BUSINESS_ADDRESS).orElse(EMPTY));
        map.put("businessPhone", this.adminUsecase.getValue(COMPANY_PROFILE_PHONE).orElse(EMPTY));
        map.put("businessEmail", this.adminUsecase.getValue(COMPANY_PROFILE_EMAIL).orElse(EMPTY));
        map.put("reportFooter", RECEIPT_FOOTER);
        return map;
    }

    public String currency() {
        Optional<String> settingValue = this.regionSetupUsecase.getSettingValue(COMPANY_REGION_CURRENCY);
        return settingValue.orElse(EMPTY);
    }
}
