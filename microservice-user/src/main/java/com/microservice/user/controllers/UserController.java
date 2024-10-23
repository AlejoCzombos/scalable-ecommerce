package com.microservice.user.controllers;

import com.microservice.user.models.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@RequestMapping("/api/users")
public interface UserController {

    @RequestMapping(
            value = "/by-id/{id}",
            method = RequestMethod.GET
    )
    @PreAuthorize("hasRole('ADMIN')")
    ResponseEntity<UserDto> getUserById(Long id);

    @RequestMapping(
            value = "/by-email/{email}",
            method = RequestMethod.GET
    )
    @PreAuthorize("hasRole('ADMIN')")
    ResponseEntity<UserDto> getUserByEmail(String email);

    @RequestMapping(
            value = "/all",
            method = RequestMethod.GET
    )
    @PreAuthorize("hasRole('ADMIN')")
    ResponseEntity<List<UserDto>> getAllUsers();

}
