package com.microservice.user.services;

import com.microservice.user.models.entities.User;

import java.util.List;

public interface UserService {

    User getUserById(Long id) throws Exception;
    User getUserByEmail(String email) throws Exception;
    List<User> getAllUsers() throws Exception;

}
