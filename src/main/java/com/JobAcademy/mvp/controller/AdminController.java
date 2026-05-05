package com.jobacademy.mvp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobacademy.mvp.model.User;
import com.jobacademy.mvp.repository.UserRepository;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final UserRepository repo;

    public AdminController(UserRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return repo.findAll()
        .stream()
        .map(u -> {
            u.setPassword(null);
            return u;
        })
        .toList();
    }

    @GetMapping("/home")
    public String adminHome() {
        return "Welcome Admin";
    }
}
