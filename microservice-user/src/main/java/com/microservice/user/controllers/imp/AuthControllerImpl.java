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

    public ResponseEntity<JwtResponse> login(@RequestBody LoginRequest request) {
        try{
            return ResponseEntity.ok(service.login(request));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity<JwtResponse> register(@RequestBody RegisterRequest request) {
        try {
            return ResponseEntity.ok(service.register(request));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
