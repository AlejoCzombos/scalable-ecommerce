package com.microservice.user.services.imp;

import com.microservice.user.mappers.UserDtoMapper;
import com.microservice.user.models.dto.UserDto;
import com.microservice.user.models.entities.User;
import com.microservice.user.repositories.UserRepository;
import com.microservice.user.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private UserRepository repository;

    @Override
    public UserDto getUserById(Long id) throws Exception {
        try {
            User user = repository.findById(id).get();
            return UserDtoMapper.toUserDto(user);
        }
        catch (Exception e) {
            System.out.println("USER NOT FOUND");
            return null;
        }
    }

    @Override
    public UserDto getUserByEmail(String email) throws Exception {
        try{
            User user = repository.findByEmail(email).get();
            return UserDtoMapper.toUserDto(user);
        }
        catch (Exception e) {
            System.out.println("USER NOT FOUND");
            return null;
        }
    }

    @Override
    public List<UserDto> getAllUsers() throws Exception {
        try {
            List<User> users = repository.findAll();
            return users.stream().map(UserDtoMapper::toUserDto).toList();
        }
        catch (Exception e) {
            System.out.println("USERS NOT FOUND");
            return null;
        }
    }
}
