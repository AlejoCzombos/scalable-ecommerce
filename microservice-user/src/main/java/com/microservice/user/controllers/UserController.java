package com.microservice.user.controllers;

import com.microservice.user.models.dto.UserDto;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@RequestMapping("/api/users")
public interface UserController {

    @RequestMapping(
            value = "/by-id/{id}",
            method = RequestMethod.GET
    )
    ResponseEntity<UserDto> getUserById(@PathVariable @NotNull(message = "Id is required") Long id) throws Exception ;

    @RequestMapping(
            value = "/by-email/{email}",
            method = RequestMethod.GET
    )
    ResponseEntity<UserDto> getUserByEmail(@PathVariable @NotNull(message = "Email is required") String email) throws Exception ;

    @RequestMapping(
            value = "/all",
            method = RequestMethod.GET
    )
    ResponseEntity<List<UserDto>> getAllUsers() throws Exception ;

}
