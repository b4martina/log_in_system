package com.example.login_project.service;


import com.example.login_project.dto.UpdatedUserRequest;
import com.example.login_project.dto.UserResponse;
import com.example.login_project.model.User;
import com.example.login_project.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service

public class UpdatedUserService {

        private UserRepository userRepository;
        private PasswordEncoder passwordEncoder;

        public void UserService(UserRepository userRepository,
                                PasswordEncoder passwordEncoder) {
            this.userRepository = userRepository;
            this.passwordEncoder = passwordEncoder;
        }


    public UpdatedUserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponse updateUser(String username, UpdatedUserRequest request) {

            User user = userRepository.findByUsername(username)
                    .orElseThrow(() -> new RuntimeException("User not found"));

            if (request.getUsername() != null) {
                user.setUsername(request.getUsername());
            }

            if (request.getEmail() != null) {
                user.setEmail(request.getEmail());
            }

            if (request.getPassword() != null) {
                user.setPassword(passwordEncoder.encode(request.getPassword()));
            }

            userRepository.save(user);

            return new UserResponse(
                    user.getUsername(),
                    user.getEmail(),
                    user.getRole()
            );
        }
    }
