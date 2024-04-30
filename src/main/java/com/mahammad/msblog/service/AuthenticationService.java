package com.mahammad.msblog.service;

import com.mahammad.msblog.model.request.UserRegisterRequest;
import com.mahammad.msblog.model.response.AuthenticationResponse;
import com.mahammad.msblog.model.response.FullUserResponse;
import com.mahammad.msblog.repository.user.UserDao;

public interface AuthenticationService {

    AuthenticationResponse registerUser(UserRegisterRequest userRegisterRequest);

    void authenticateUser(String token);

    FullUserResponse getUser(String header);

}
