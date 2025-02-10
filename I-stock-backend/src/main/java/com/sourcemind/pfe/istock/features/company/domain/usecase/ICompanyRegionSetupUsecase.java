package com.sourcemind.pfe.istock.features.company.domain.usecase;

import com.sourcemind.pfe.istock.features.company.domain.entity.CompanyRegionDetail;
import com.sourcemind.pfe.istock.features.settings.domain.entity.Setting;

import java.util.List;
import java.util.Optional;

public interface ICompanyRegionSetupUsecase {

    List<CompanyRegionDetail> all();

    Optional<CompanyRegionDetail> get(String key);

    Optional<Boolean> update(String key, String value);

    void updateMany(List<CompanyRegionDetail> list);

    Setting getAsSetting(String key);

    Optional<String> getSettingValue(String key);

}
