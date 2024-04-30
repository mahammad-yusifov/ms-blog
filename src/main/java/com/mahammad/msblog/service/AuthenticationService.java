package com.mahammad.msblog.service;

import com.mahammad.msblog.model.request.UserRegisterRequest;
import com.mahammad.msblog.model.response.AuthenticationResponse;

public interface AuthenticationService {

    AuthenticationResponse registerUser(UserRegisterRequest userRegisterRequest);

    AuthenticationResponse authenticateUser(String token);

}
