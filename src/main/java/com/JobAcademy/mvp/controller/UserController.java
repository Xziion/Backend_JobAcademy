package com.jobacademy.mvp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

import com.jobacademy.mvp.model.User;
import com.jobacademy.mvp.repository.UserRepository;

public class UserController {

    private final UserRepository repo;

    public UserController(UserRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return repo.save(user);
    }

    @GetMapping
    public List<User> listAllUsers() {
        return repo.findAll();
    }


}