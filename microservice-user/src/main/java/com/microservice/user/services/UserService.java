package com.microservice.user.services;

import com.microservice.user.models.dto.UserDto;
import com.microservice.user.models.entities.User;

import java.util.List;

public interface UserService {

    UserDto getUserById(Long id);
    UserDto getUserByEmail(String email);
    List<UserDto> getAllUsers();

}
