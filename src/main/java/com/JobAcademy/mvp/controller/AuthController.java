package com.jobacademy.mvp.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobacademy.mvp.model.User;
import com.jobacademy.mvp.services.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService service;

    public AuthController(UserService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return service.registerUser(user);
    }
    
}
