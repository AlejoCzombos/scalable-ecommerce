package com.microservice.user.controllers;

import com.microservice.user.models.dto.JwtResponse;
import com.microservice.user.models.dto.LoginRequest;
import com.microservice.user.models.dto.RegisterRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/api/auth")
public interface AuthController {

    @RequestMapping(
            value = "/login",
            method = RequestMethod.POST
    )
    ResponseEntity<JwtResponse> login(@RequestBody LoginRequest request);

    @RequestMapping(
            value = "/register",
            method = RequestMethod.POST
    )
    ResponseEntity<JwtResponse> register(@RequestBody RegisterRequest request);

}
