package com.example.login_project.service;

import com.example.login_project.dto.AuthResponse;
import com.example.login_project.dto.LogInRequest;
import com.example.login_project.dto.RegisterRequest;
import com.example.login_project.model.User;
import com.example.login_project.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;



    public AuthService (UserRepository userRepository, PasswordEncoder passwordEncoder,
                        JwtService jwtService){
    this.userRepository= userRepository;
    this.passwordEncoder= passwordEncoder;
    this.jwtService=jwtService;

    }
    public AuthResponse register (RegisterRequest dto) {
        if (userRepository.existsByUsername(dto.getUsername())) {
            throw new RuntimeException("Username already exists");
        }

            if (userRepository.existsByEmail(dto.getEmail())) {
                throw new RuntimeException("Email already exists");
            }

            User user = new User();
            user.setUsername(dto.getUsername());
            user.setPassword(passwordEncoder.encode(dto.getPassword()));
            user.setName(dto.getName());
            user.setSurname(dto.getSurname());
            user.setEmail(dto.getEmail());
            user.setRole("USER");

            userRepository.save(user);

            String token = jwtService.generateToken(user.getUsername());

            return new AuthResponse(token, "User registered successfully",
                    user.getUsername(), user.getRole());
        }

        public AuthResponse login (LogInRequest dto){
            User user = userRepository.findByUsername(dto.getUsername()).orElseThrow(() ->
                    new RuntimeException("User not found"));

            if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
                throw new RuntimeException("Invalid Password");

            }

            String token = jwtService.generateToken(user.getUsername());

            return new AuthResponse(token, "Login succesful",
                    user.getUsername(), user.getRole());
        }







    }
