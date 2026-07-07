package com.example.login_project.controllers;


import com.example.login_project.dto.*;
import com.example.login_project.service.AuthService;
import com.example.login_project.service.UpdatedUserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
    @RequestMapping ("/auth")
    public class AuthController {
    private final AuthService authService;
    private final UpdatedUserService updatedUserService;
    public AuthController(AuthService authService, UpdatedUserService updatedUserService) {
        this.authService = authService;
        this.updatedUserService = updatedUserService;
    }

    @PostMapping("/register")

public AuthResponse register (@RequestBody RegisterRequest request){
    return authService.register(request);
}

    @PostMapping("/login")

    public AuthResponse login (@RequestBody LogInRequest request){
        return authService.login(request);


        }

        @PutMapping("/update")
        public UserResponse updateUser(@RequestBody UpdatedUserRequest request) {

            String username = SecurityContextHolder.getContext()
                    .getAuthentication()
                    .getName();

            return updatedUserService.updateUser(username, request);
        }


        }
