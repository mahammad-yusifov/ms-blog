package com.mahammad.msblog.controller;

import com.mahammad.msblog.model.request.UserRegisterRequest;
import com.mahammad.msblog.model.response.AuthenticationResponse;
import com.mahammad.msblog.service.impl.AuthenticationServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth/v1")
@RequiredArgsConstructor
@Slf4j
public class AuthenticationController {

    private final AuthenticationServiceImpl authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody UserRegisterRequest userRegisterRequest) {
        log.debug("user register for {} start", userRegisterRequest.getEmail());
        AuthenticationResponse authenticationResponse = authenticationService.registerUser(userRegisterRequest);
        log.debug("user register for {} end", userRegisterRequest.getEmail());
        return ResponseEntity.ok(authenticationResponse);
    }

//    @PostMapping("/authenticate")
//    public ResponseEntity<AuthenticationResponse> authenticate(@RequestHeader("Authorization") String authorizationHeader) {
//        log.debug("user authenticate for start");
//        AuthenticationResponse authenticationResponse = authenticationService.authenticateUser(token);
//        log.debug("user authenticate for end");
//        return ResponseEntity.ok(authenticationResponse);
//    }

//    @GetMapping("/user")
//    public ResponseEntity<AuthenticationResponse> getUser(@RequestHeader("Authorization") String authorizationHeader) {
//        log.debug("get user start");
//        GetUserResponse getUserResponse = authenticationService.getUser(authorizationHeader);
//        log.debug("get user end");
//        return ResponseEntity.ok(getUserResponse);
//    }

}
