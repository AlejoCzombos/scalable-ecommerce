package com.microservice.user.models.dto.request;

import jakarta.validation.constraints.*;
import lombok.Data;
@Data
public class RegisterRequest {

    @Email(message = "Email should be valid")
    @NotNull(message = "Email is required")
    private String email;

    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$",
            message = "Password must be at least 8 characters and contain at least one letter and one number")
    @NotNull(message = "Password is required")
    private String password;

    private String firstName;
    private String lastName;
    private String phone;
}
