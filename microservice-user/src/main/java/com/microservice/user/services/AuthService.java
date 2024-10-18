package com.microservice.user.services;

import com.microservice.user.models.dto.JwtResponse;
import com.microservice.user.models.dto.LoginRequest;
import com.microservice.user.models.dto.RegisterRequest;

public interface AuthService {

    JwtResponse login(LoginRequest request) throws Exception;

    JwtResponse register(RegisterRequest request) throws Exception;

}