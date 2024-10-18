package com.microservice.user.controllers;

import com.microservice.user.models.dto.JwtResponse;
import com.microservice.user.models.dto.LoginRequest;
import com.microservice.user.models.dto.RegisterRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public interface AuthController {

    ResponseEntity<JwtResponse> login(@RequestBody LoginRequest request);

    ResponseEntity<JwtResponse> register(@RequestBody RegisterRequest request);

}
