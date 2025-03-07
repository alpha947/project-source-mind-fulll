
package com.sourcemind.pfe.istock.features.company.data.usecase_impl;

import com.sourcemind.pfe.istock.core.annotations.Usecase;
import com.sourcemind.pfe.istock.features.company.data.repository.CompanyAdministratorDetailRepository;
import com.sourcemind.pfe.istock.features.company.domain.entity.CompanyAdministratorDetail;
import com.sourcemind.pfe.istock.features.company.domain.usecase.ICompanyAdministratorSetupUsecase;
import com.sourcemind.pfe.istock.features.settings.domain.entity.Setting;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Usecase
@RequiredArgsConstructor
public class CompanyAdministratorSetupUsecaseImpl implements ICompanyAdministratorSetupUsecase {

    private final CompanyAdministratorDetailRepository repository;

    @Override
    public List<CompanyAdministratorDetail> all() {
        return this.repository.findAll();
    }

    @Override
    public Optional<CompanyAdministratorDetail> get(String key) {
        return this.repository.findBySetupKeyEqualsIgnoreCase(key);
    }

    @Override
    public Setting getAsSetting(String key) {
        Optional<CompanyAdministratorDetail> optional = this.get(key);
        return optional.map(admin -> new Setting(admin.getSetupKey(), admin.getSetupValue())).orElse(new Setting());
    }


    @Override
    public Optional<Boolean> update(String key, String value) {
        Optional<CompanyAdministratorDetail> optional = this.get(key);
        return optional.map(detail -> {
            int count = this.repository.updateValueWhereKey(value, key);
            return count == 1;
        });
    }

    @Override
    @Transactional
    public void updateMany(List<CompanyAdministratorDetail> list) {
        list.forEach(basicDetail -> {
            this.update(basicDetail.getSetupKey(), basicDetail.getSetupValue());
        });
    }

    @Override
    public Optional<String> getValue(String key) {
        Optional<CompanyAdministratorDetail> optional = this.get(key);
        return optional.map(CompanyAdministratorDetail::getSetupValue);
    }
}
