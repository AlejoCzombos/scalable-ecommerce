package com.microservice.user.controllers.imp;

import com.microservice.user.controllers.UserController;
import com.microservice.user.models.dto.UserDto;
import com.microservice.user.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {

    private final UserService service;

    @Override
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<UserDto> getUserById(Long id) {
        return ResponseEntity.ok(service.getUserById(id));
    }

    @Override
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<UserDto> getUserByEmail(String email) {
        return ResponseEntity.ok(service.getUserByEmail(email));
    }

    @Override
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok(service.getAllUsers());
    }
}
