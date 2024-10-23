package com.microservice.user.mappers;

import com.microservice.user.models.dto.UserDto;
import com.microservice.user.models.entities.User;

public class UserDtoMapper {

    public static UserDto toUserDto(User user) {
        return UserDto.builder()
                .user_id(user.getId())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .phone(user.getPhone())
                .role(user.getRole().toString())
                .build();
    }

}
