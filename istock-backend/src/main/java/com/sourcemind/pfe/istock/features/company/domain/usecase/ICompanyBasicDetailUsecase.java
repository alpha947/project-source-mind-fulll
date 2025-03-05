package com.sourcemind.pfe.istock.features.company.domain.usecase;

import com.sourcemind.pfe.istock.features.company.domain.entity.CompanyBasicDetail;
import com.sourcemind.pfe.istock.features.settings.domain.entity.Setting;

import java.util.List;
import java.util.Optional;

public interface ICompanyBasicDetailUsecase {

    List<CompanyBasicDetail> all();

    Optional<CompanyBasicDetail> get(String key);

    Setting getAsSetting(String key);

    Optional<Boolean> update(String key, String value);

    void updateMany(List<CompanyBasicDetail> list);

    Optional<String> getValue(String key);
}
