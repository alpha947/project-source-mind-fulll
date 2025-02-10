

package com.sourcemind.pfe.istock.features.company.data.interactor.implementation;

import com.sourcemind.pfe.istock.core.annotations.Interactor;
import com.sourcemind.pfe.istock.core.mapper.Mapper;
import com.sourcemind.pfe.istock.core.params.PageSearchRequest;
import com.sourcemind.pfe.istock.core.params.PageSearchResult;
import com.sourcemind.pfe.istock.core.utils.Util;
import com.sourcemind.pfe.istock.features.authentication.data.request.RoleRequest;
import com.sourcemind.pfe.istock.features.authentication.data.request.UserRequest;
import com.sourcemind.pfe.istock.features.authentication.domain.entity.Role;
import com.sourcemind.pfe.istock.features.authentication.domain.entity.User;
import com.sourcemind.pfe.istock.features.authentication.domain.usecase.IRoleUsecase;
import com.sourcemind.pfe.istock.features.authentication.domain.usecase.IUserUsecase;
import com.sourcemind.pfe.istock.features.company.data.interactor.contract.ICompanyEmployeeInteractor;
import com.sourcemind.pfe.istock.features.company.data.request.CompanyEmployeeNokDetailRequest;
import com.sourcemind.pfe.istock.features.company.data.request.CompanyEmployeePersonalDetailRequest;
import com.sourcemind.pfe.istock.features.company.data.request.CompanyEmployeeRequest;
import com.sourcemind.pfe.istock.features.company.data.request.CompanyEmployeeSearchRequest;
import com.sourcemind.pfe.istock.features.company.domain.entity.CompanyEmployee;
import com.sourcemind.pfe.istock.features.company.domain.entity.CompanyEmployeeNokDetail;
import com.sourcemind.pfe.istock.features.company.domain.entity.CompanyEmployeePersonalDetail;
import com.sourcemind.pfe.istock.features.company.domain.usecase.ICompanyEmployeeNokDetailUsecase;
import com.sourcemind.pfe.istock.features.company.domain.usecase.ICompanyEmployeePersonalDetailUsecase;
import com.sourcemind.pfe.istock.features.company.domain.usecase.ICompanyEmployeeUsecase;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

import static com.sourcemind.pfe.istock.core.params.PageParam.toPageSearchResult;
import static com.sourcemind.pfe.istock.features.company.data.request.specification.CompanyEmployeeSearchSpecification.companyEmployeeSpecification;
import static org.springframework.http.ResponseEntity.ok;

@Interactor
@RequiredArgsConstructor
public class CompanyEmployeeInteractorImpl implements ICompanyEmployeeInteractor, Mapper<CompanyEmployeeRequest, CompanyEmployee> {
    private final ICompanyEmployeeUsecase usecase;
    private final ModelMapper modelMapper;
    private final ICompanyEmployeePersonalDetailUsecase personalDetailUsecase;
    private final ICompanyEmployeeNokDetailUsecase nokDetailUsecase;
    private final IUserUsecase userUsecase;
    private final IRoleUsecase roleUsecase;

    @Override
    public ResponseEntity<PageSearchResult<List<CompanyEmployeeRequest>>> search(PageSearchRequest<CompanyEmployeeSearchRequest> request) {
        Page<CompanyEmployee> page = this.usecase.findMany(companyEmployeeSpecification(request.getSearchRequest()), request.getPage().toPageable());
        Set<CompanyEmployee> employees = new HashSet<>(page.getContent());
        List<CompanyEmployeeRequest> requests = employees.stream().map(this::toRequest).collect(Collectors.toList());
        return ok().body(toPageSearchResult(requests, page));
    }

    @Override
    @Transactional
    public ResponseEntity<CompanyEmployeeRequest> save(CompanyEmployeeRequest employeeRequest) {
        CompanyEmployee companyEmployee = setPartialEmployeeModels(employeeRequest);
        CompanyEmployee saveEmployee = this.usecase.save(companyEmployee);
        return ok().body(toRequest(saveEmployee));
    }

    private CompanyEmployee setPartialEmployeeModels(CompanyEmployeeRequest customer) {
        CompanyEmployee customerModel = this.toModel(customer);
        CompanyEmployeePersonalDetailRequest personalDetail = customer.getPersonalDetail();
        customerModel.setAccountDetail(getNewAccountDetailFromRequest(customer.getAccountDetail(), personalDetail.getFullName()));
        customerModel.setPersonalDetail(getPersonalDetailFromRequest(personalDetail));
        customerModel.setNokDetail(getNokDetailFromRequest(customer.getNokDetail()));
        return customerModel;
    }

    private User getNewAccountDetailFromRequest(UserRequest accountDetail, String name) {
        this.userUsecase.checkDuplicateUsername(accountDetail.getUsername());

        User userModel = this.toUserModel(accountDetail);
        userModel.setRoles(getAccountRoles(accountDetail.getRoles()));
        userModel.setName(name);
        return this.userUsecase.save(userModel);
    }

    private Set<Role> getAccountRoles(Collection<RoleRequest> roleRequests) {
        Set<Role> roles = new HashSet<>();
        roleRequests.forEach(request -> {
            Optional<Role> optionalRole = this.roleUsecase.getOne(request.getId());
            optionalRole.ifPresent(roles::add);
        });
        return roles;
    }

    private CompanyEmployeePersonalDetail getPersonalDetailFromRequest(CompanyEmployeePersonalDetailRequest personalDetailRequest) {
        CompanyEmployeePersonalDetail personalDetailModel = toPersonalDetailModel(personalDetailRequest);
        return this.personalDetailUsecase.save(personalDetailModel);
    }

    private CompanyEmployeeNokDetail getNokDetailFromRequest(CompanyEmployeeNokDetailRequest nokDetailRequest) {
        CompanyEmployeeNokDetail nokDetailModel = toNokDetailModel(nokDetailRequest);
        return this.nokDetailUsecase.save(nokDetailModel);
    }

    @Override
    public ResponseEntity<Optional<Boolean>> update(CompanyEmployeeRequest customer) {
        CompanyEmployee employee = toModel(customer);
        Optional<Boolean> optionalBoolean = this.usecase.update(employee);
        return ok().body(optionalBoolean);
    }

    @Override
    public ResponseEntity<Optional<Boolean>> toggleActiveStatus(Long id) {
        Optional<Boolean> optional = this.usecase.toggleActiveStatus(id);
        return ok().body(optional);
    }

    @Override
    public CompanyEmployeeRequest toRequest(CompanyEmployee model) {
        return this.modelMapper.map(model, CompanyEmployeeRequest.class);
    }

    @Override
    public CompanyEmployee toModel(CompanyEmployeeRequest request) {
        return this.modelMapper.map(request, CompanyEmployee.class);
    }

    private CompanyEmployeePersonalDetailRequest toPersonalDetailRequest(CompanyEmployeePersonalDetail model) {
        return this.modelMapper.map(model, CompanyEmployeePersonalDetailRequest.class);
    }

    private CompanyEmployeeNokDetailRequest toNokDetailRequest(CompanyEmployeeNokDetail model) {
        return this.modelMapper.map(model, CompanyEmployeeNokDetailRequest.class);

    }

    private CompanyEmployeePersonalDetail toPersonalDetailModel(CompanyEmployeePersonalDetailRequest request) {
        CompanyEmployeePersonalDetail detail = this.modelMapper.map(request, CompanyEmployeePersonalDetail.class);
        detail.setEmployeeDateOfBirth(Util.parseToLocalDate(request.getEmployeeDateOfBirth()));
        return detail;
    }

    private CompanyEmployeeNokDetail toNokDetailModel(CompanyEmployeeNokDetailRequest request) {
        return this.modelMapper.map(request, CompanyEmployeeNokDetail.class);

    }

    private User toUserModel(UserRequest userRequest) {
        return this.modelMapper.map(userRequest, User.class);
    }

    private UserRequest toUserRequest(User model) {
        return this.modelMapper.map(model, UserRequest.class);
    }
}
