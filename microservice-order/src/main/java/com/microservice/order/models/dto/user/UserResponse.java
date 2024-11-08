package com.microservice.order.models.dto.user;

import lombok.Data;

@Data
public class UserResponse {
    private Long user_id;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    private String role;
}
