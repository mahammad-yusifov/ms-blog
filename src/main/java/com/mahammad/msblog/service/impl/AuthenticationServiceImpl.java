package com.mahammad.msblog.service.impl;

import com.mahammad.msblog.exception.ErrorCode;
import com.mahammad.msblog.exception.NotFoundException;
import com.mahammad.msblog.exception.UserAlreadyExistsException;
import com.mahammad.msblog.exception.UserBlockedException;
import com.mahammad.msblog.mapper.AuthenticationMapper;
import com.mahammad.msblog.model.request.UserRegisterRequest;
import com.mahammad.msblog.model.response.AuthenticationResponse;
import com.mahammad.msblog.model.response.FullUserResponse;
import com.mahammad.msblog.repository.user.UserPermissions;
import com.mahammad.msblog.repository.user.UserRepository;
import com.mahammad.msblog.repository.user.UserDao;
import com.mahammad.msblog.service.AuthenticationService;
import com.mahammad.msblog.service.JwtService;
import com.mahammad.msblog.util.Util;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService{

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final AuthenticationMapper authenticationMapper;
    private final Util util;

    @Override
    public AuthenticationResponse registerUser(UserRegisterRequest userRegisterRequest) {

        if (repository.findByUserName(userRegisterRequest.getUserName()).isPresent()) {
            throw new UserAlreadyExistsException(ErrorCode.USER_ALREADY_EXISTS, "User already exists with this email");
        }

        UserDao user = authenticationMapper.toUserDao(userRegisterRequest);
        user.setPassword(passwordEncoder.encode(userRegisterRequest.getPassword()));
        repository.save(user);
        String jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .userId(user.getId())
                .token(jwtToken)
                .build();
    }

    @Override
    public void authenticateUser(String header) {

        UserDao user = util.getUserFromAuthHeader(header);

        if (user.isAccountBlocked()) {
            throw new UserBlockedException(ErrorCode.USER_BLOCK, "Your account is blocked. " +
                    "Please contact through our customer support portal");
        }

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getUsername(),
                        user.getPassword()
                )
        );

    }


    @Override
    public FullUserResponse getUser(String header) {

        UserDao user = util.getUserFromAuthHeader(header);

        FullUserResponse fullUserResponse = new FullUserResponse();
        fullUserResponse.setUser(user);
        UserPermissions userPermissions = repository.findUserWithPermissions(user.getId(),
                user.getUserTypeId()).orElseThrow(() -> new NotFoundException(null, null));
        fullUserResponse.setPermissions(userPermissions);

        return fullUserResponse;
    }
}
