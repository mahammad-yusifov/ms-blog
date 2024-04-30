package com.mahammad.msblog.mapper;

import com.mahammad.msblog.model.request.UserRegisterRequest;
import com.mahammad.msblog.repository.user.UserDao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AuthenticationMapper {

    @Mapping(target = "userName", source = "userRegisterRequest.userName")
    @Mapping(target = "password", source = "userRegisterRequest.password")
    @Mapping(target = "name", source = "userRegisterRequest.name")
    @Mapping(target = "surname", source = "userRegisterRequest.surname")
    @Mapping(target = "phoneNumber", source = "userRegisterRequest.phoneNumber")
    @Mapping(target = "email", source = "userRegisterRequest.email")
    @Mapping(target = "userTypeId", source = "userRegisterRequest.userTypeId")
    @Mapping(target = "birthDate", source = "userRegisterRequest.birthDate")
    UserDao toUserDao(UserRegisterRequest userRegisterRequest);
}
