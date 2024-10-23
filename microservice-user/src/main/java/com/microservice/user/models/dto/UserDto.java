package com.microservice.user.models.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {

    private Long user_id;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    private String role;
}
