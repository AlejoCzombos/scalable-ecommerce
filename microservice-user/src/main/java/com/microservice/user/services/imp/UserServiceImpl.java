package com.microservice.user.services.imp;

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
    public User getUserById(Long id) throws Exception {
        try {
            return repository.findById(id).get();
        }
        catch (Exception e) {
            System.out.println("USER NOT FOUND");
            return null;
        }
    }

    @Override
    public User getUserByEmail(String email) throws Exception {
        try{
            return repository.findByEmail(email).get();
        }
        catch (Exception e) {
            System.out.println("USER NOT FOUND");
            return null;
        }
    }

    @Override
    public List<User> getAllUsers() throws Exception {
        try {
            return repository.findAll();
        }
        catch (Exception e) {
            System.out.println("USERS NOT FOUND");
            return null;
        }
    }
}
