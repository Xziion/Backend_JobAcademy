package com.jobacademy.mvp.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jobacademy.mvp.model.User;
import com.jobacademy.mvp.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository repo;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository repo, PasswordEncoder passwordEncoder) {
        this.repo = repo;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(User user) {
        if(repo.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("Email Already used!");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return repo.save(user);
    }
    
}
