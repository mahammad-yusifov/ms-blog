package com.mahammad.msblog.util;

import com.mahammad.msblog.repository.user.UserDao;
import com.mahammad.msblog.repository.user.UserRepository;
import com.mahammad.msblog.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Util {

    private final JwtService jwtService;
    private final UserRepository userRepository;

    public UserDao getUserFromAuthHeader(String header) {
        String token = jwtService.extractToken(header);
        String userName = jwtService.extractUsername(token);
        return userRepository.findByUserName(userName).orElseThrow(() -> new BadCredentialsException(null));
    }
}
