package com.mahammad.msblog.mapper;

import com.mahammad.msblog.model.request.UserRegisterRequest;
import com.mahammad.msblog.repository.user.UserDao;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AuthenticationMapper {

    UserDao toUserDao(UserRegisterRequest userRegisterRequest);
}
