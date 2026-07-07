package com.example.login_project.service;

import com.example.login_project.dto.RegisterRequest;
import com.example.login_project.dto.UserResponse;
import com.example.login_project.model.User;
import com.example.login_project.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

public class UserService {
private final UserRepository userRepository;
private  final PasswordEncoder passwordEncoder;

public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder){
   this.userRepository = userRepository;
   this.passwordEncoder= passwordEncoder;

}
public UserResponse createUser(RegisterRequest dto){
    if (userRepository.existsByUsername(dto.getUsername())){
        throw new RuntimeException("The username entered already exists.");
    }

    if (userRepository.existsByEmail(dto.getEmail())){
        throw new RuntimeException("The email entered already exists.");

    }

    User user= new User();
    user.setUsername(dto.getUsername());
    user.setPassword(passwordEncoder.encode(dto.getPassword()));
    user.setName(dto.getName());
    user.setSurname(dto.getSurname());
    user.setEmail(dto.getEmail());
    user.setRole("USER");

    User savedUser = userRepository.save(user);

    return new UserResponse
            (savedUser.getId(), savedUser.getUsername(), savedUser.getName(), savedUser.getSurname(),
                    savedUser.getEmail(), savedUser.getRole());

}

public UserResponse getUserByUsername(String username){

    User user = userRepository.findByUsername(username)
            .orElseThrow(() -> new RuntimeException("User not found!"));

    return new UserResponse(user.getId(), user.getUsername(), user.getName(), user.getSurname(),
            user.getEmail(),user.getRole());
}

public boolean existsByUsername(String username){
    return userRepository.existsByUsername(username);
}

public boolean existsByEmail (String email){
    return userRepository.existsByEmail(email);

}

    public UserResponse getUserResponse(String username){

    User user =userRepository.findByUsername(username).orElseThrow(()->new RuntimeException("User does not exist."));

    UserResponse response = new UserResponse();
    response.setId(user.getId());
    response.setUsername(user.getUsername());
    response.setName(user.getName());
    response.setSurname(user.getSurname());
    response.setEmail(user.getEmail());
    response.setRole(user.getRole());



        return response;
    }
}
