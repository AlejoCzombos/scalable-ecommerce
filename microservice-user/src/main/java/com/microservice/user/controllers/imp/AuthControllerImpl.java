package com.microservice.user.controllers.imp;

import com.microservice.user.controllers.AuthController;
import com.microservice.user.models.dto.JwtResponse;
import com.microservice.user.models.dto.request.LoginRequest;
import com.microservice.user.models.dto.request.RegisterRequest;
import com.microservice.user.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthControllerImpl implements AuthController {

    private final AuthService service;

    public ResponseEntity<JwtResponse> login(@RequestBody LoginRequest request) throws Exception {
        return new ResponseEntity<>(service.login(request), HttpStatus.OK);
    }

    public ResponseEntity<JwtResponse> register(@RequestBody RegisterRequest request) throws Exception {
        return new ResponseEntity<>(service.register(request), HttpStatus.CREATED);
    }
}
