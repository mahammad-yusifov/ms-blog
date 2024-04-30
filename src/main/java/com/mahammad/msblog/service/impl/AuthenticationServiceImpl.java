package com.mahammad.msblog.service.impl;

import com.mahammad.msblog.exception.ErrorCode;
import com.mahammad.msblog.exception.UserAlreadyExistsException;
import com.mahammad.msblog.exception.UserBlockedException;
import com.mahammad.msblog.mapper.AuthenticationMapper;
import com.mahammad.msblog.model.request.UserRegisterRequest;
import com.mahammad.msblog.model.response.AuthenticationResponse;
import com.mahammad.msblog.repository.user.UserRepository;
import com.mahammad.msblog.repository.user.UserDao;
import com.mahammad.msblog.service.AuthenticationService;
import com.mahammad.msblog.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository repository;
    //    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    //    private final AuthenticationManager authenticationManager;
    private final AuthenticationMapper authenticationMapper;

    @Override
    public AuthenticationResponse registerUser(UserRegisterRequest userRegisterRequest) {

        if (repository.findByEmail(userRegisterRequest.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException(ErrorCode.USER_ALREADY_EXISTS, "User already exists with this email");
        }

        UserDao user = authenticationMapper.toUserDao(userRegisterRequest);

        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .userId(user.getId())
                .token(jwtToken)
                .build();
    }

    @Override
    public AuthenticationResponse authenticateUser(String token) {

        UserDao user = repository.findByEmail(email).orElseThrow(() -> new BadCredentialsException(null));


        if (user.isAccountBlocked()) {
            throw new UserBlockedException(ErrorCode.USER_BLOCK, "Your account is blocked. " +
                    "Please contact through our customer support portal");
        }

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        login,
                        userRegisterRequest.getPassword()
                )
        );

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .userId(user.getId())
                .token(jwtToken)
                .build();
    }
}
