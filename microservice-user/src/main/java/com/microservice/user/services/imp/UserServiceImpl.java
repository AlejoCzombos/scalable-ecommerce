package com.microservice.user.services.imp;

import com.microservice.user.expections.UserNotFoundException;
import com.microservice.user.mappers.UserDtoMapper;
import com.microservice.user.models.dto.UserDto;
import com.microservice.user.models.entities.User;
import com.microservice.user.repositories.UserRepository;
import com.microservice.user.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public UserDto getUserById(Long id) {
        User user = repository.findById(id).orElseThrow( () -> new UserNotFoundException(UserNotFoundException.MESSAGE_USER_NOT_FOUND + "with id: " + id));
        return UserDtoMapper.toUserDto(user);
    }

    @Override
    public UserDto getUserByEmail(String email) {
        User user = repository.findByEmail(email).orElseThrow( () -> new UserNotFoundException(UserNotFoundException.MESSAGE_USER_NOT_FOUND + "with email: " + email));
        return UserDtoMapper.toUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = repository.findAll();
        return users.stream().map(UserDtoMapper::toUserDto).toList();
    }
}
