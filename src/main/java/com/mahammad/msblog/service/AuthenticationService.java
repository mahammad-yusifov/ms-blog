package com.mahammad.msblog.service;

import com.mahammad.msblog.exception.ErrorCode;
import com.mahammad.msblog.exception.UserAlreadyExistsException;
import com.mahammad.msblog.mapper.AuthenticationMapper;
import com.mahammad.msblog.model.request.UserRegisterRequest;
import com.mahammad.msblog.model.response.AuthenticationResponse;
import com.mahammad.msblog.repository.UserRepository;
import com.mahammad.msblog.repository.dao.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final AuthenticationMapper authenticationMapper;

    public AuthenticationResponse registerUser(UserRegisterRequest userRegisterRequest) {

        if (repository.findByEmail(userRegisterRequest.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException(ErrorCode.USER_ALREADY_EXISTS, "User already exists with this email");
        }

        UserDao userDao = authenticationMapper.toUserDao(userRegisterRequest);

        LocalDate birthDate = userRegisterRequest.getBirthDate();
        if (birthDate != null) {
            userDaoBuilder.birthDate(Date.valueOf(birthDate));
        } else {
            userDaoBuilder.birthDate(null);
        }

        UserDao user = userDaoBuilder.build();

        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .userId(user.getId())
                .token(jwtToken)
                .build();
    }

//    public AuthenticationResponse authenticateUser(AuthenticationRequest userRegisterRequest) {
//        String login = userRegisterRequest.getLogin();
//
//        UserDao user;
//        if (PhoneNumberCheckerUtil.isAzerbaijaniPhoneNumber(login)) {
//            user = repository.findByGsmNumber(login).orElseThrow(() -> new BadCredentialsException(null));
//        } else {
//            throw new BadCredentialsException(null);
//        }
//
//        if (user.isAccountBlocked()) {
//            throw new UserBlockedException(ErrorCode.USER_BLOCK, "Hesabınız bloklanmışdır. " +
//                    "Zəhmət olmasa bizimlə əlaqə saxlayın.");
//        }
//
//        authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        login,
//                        userRegisterRequest.getPassword()
//                )
//        );
//
//        var jwtToken = jwtService.generateToken(user);
//        return AuthenticationResponse.builder()
//                .userId(user.getId())
//                .token(jwtToken)
//                .build();
//    }
}
