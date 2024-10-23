package com.microservice.user.models.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginRequest {
    @NotNull(message = "Email is required")
    String email;
    @NotNull(message = "Password is required")
    String password;
}
