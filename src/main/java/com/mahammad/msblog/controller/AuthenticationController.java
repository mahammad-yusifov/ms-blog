package com.mahammad.msblog.controller;

import com.mahammad.msblog.model.request.UserRegisterRequest;
import com.mahammad.msblog.model.response.AuthenticationResponse;
import com.mahammad.msblog.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth/v1")
@RequiredArgsConstructor
@Slf4j
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody UserRegisterRequest userRegisterRequest) {
        log.debug("user register for {} start", userRegisterRequest.getEmail());
        AuthenticationResponse authenticationResponse = authenticationService.registerUser(userRegisterRequest);
        log.debug("user register for {} end", userRegisterRequest.getEmail());
        return ResponseEntity.ok(authenticationResponse);
    }

//    @PostMapping("/authenticate")
//    public ResponseEntity<AuthenticationResponse> authenticate(@RequestHeader("Bearer") String token) {
//        log.debug("user authenticate for {} start", authenticationRequest.getLogin());
//        AuthenticationResponse authenticationResponse = authenticationService.authenticateUser(authenticationRequest);
//        log.debug("user authenticate for {} end", authenticationRequest.getLogin());
//        return ResponseEntity.ok(authenticationResponse);
//    }

}
