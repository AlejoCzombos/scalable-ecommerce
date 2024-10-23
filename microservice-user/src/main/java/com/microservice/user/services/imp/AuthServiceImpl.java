package com.microservice.user.services.imp;

import com.microservice.user.models.dto.JwtResponse;
import com.microservice.user.models.dto.request.LoginRequest;
import com.microservice.user.models.dto.request.RegisterRequest;
import com.microservice.user.models.entities.User;
import com.microservice.user.models.enums.UserRole;
import com.microservice.user.repositories.UserRepository;
import com.microservice.user.services.AuthService;

import com.microservice.user.utils.JwtUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {

    private final JwtUtil jwtUtil;

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    @Override
    public JwtResponse login(LoginRequest request) throws Exception {
        try {
            authenticate(request.getEmail(), request.getPassword());

            User user = userRepository.findByEmail(request.getEmail())
                    .orElseThrow(() -> new UsernameNotFoundException("User not found"));

            String token = jwtUtil.generateToken(user);

            return new JwtResponse(token);
        } catch (BadCredentialsException | UsernameNotFoundException e) {
            System.out.println(e.getMessage());
            throw new BadCredentialsException("Incorrect username or password");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public JwtResponse register(RegisterRequest request) throws Exception {
        try {
            User user = createUserFromRegistration(request);
            user = userRepository.save(user);

            String token = jwtUtil.generateToken(user);
            return new JwtResponse(token);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    private void authenticate(String username, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
    }

    private User createUserFromRegistration(RegisterRequest register) {
        User user = User.builder()
                .email(register.getEmail())
                .password(passwordEncoder.encode(register.getPassword()))
                .firstName(register.getFirstName())
                .lastName(register.getLastName())
                .phone(register.getPhone())
                .role(UserRole.CUSTOMER)
                .build();

        return user;
    }
}
