package com.example.login_project.service;

//fith order, did some changes to make fit for 2 roles
import com.example.login_project.model.User;
import com.example.login_project.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.*;

import java.util.Collections;
import java.util.List;

@Service
public class CustomUserDetailsService implements  UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("User not found"));

    /*return new  org.springframework.security.core.userdetails.User
            (user.getUsername(), user.getPassword(), Collections.emptyList());
    */

    return new org.springframework.security.core.userdetails.User(
            user.getUsername(),
            user.getPassword(),
            List.of(new SimpleGrantedAuthority("ROLE_" + user.getRole()))
    );

    }
}



