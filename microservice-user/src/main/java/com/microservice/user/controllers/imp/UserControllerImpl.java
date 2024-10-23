package com.microservice.user.controllers.imp;

import com.microservice.user.controllers.UserController;
import com.microservice.user.models.dto.UserDto;
import com.microservice.user.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {

    private final UserService service;

    @Override
    public ResponseEntity<UserDto> getUserById(Long id) {
        try {
            return ResponseEntity.ok(service.getUserById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<UserDto> getUserByEmail(String email) {
        try {
            return ResponseEntity.ok(service.getUserByEmail(email));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<List<UserDto>> getAllUsers() {
        try {
            return ResponseEntity.ok(service.getAllUsers());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
