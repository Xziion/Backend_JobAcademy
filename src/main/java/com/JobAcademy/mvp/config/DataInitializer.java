package com.jobacademy.mvp.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.jobacademy.mvp.model.Rol;
import com.jobacademy.mvp.model.User;
import com.jobacademy.mvp.repository.UserRepository;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository repo;
    private final PasswordEncoder encoder;

    public DataInitializer(UserRepository repo, PasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
    }

    @Override
    public void run(String... args) {

        if (repo.findByEmail("admin@test.com").isEmpty()) {

            User admin = new User();
            admin.setName("Admin");
            admin.setEmail("admin@test.com");
            admin.setPassword(encoder.encode("123456"));
            admin.setRol(Rol.ADMIN);

            repo.save(admin);
        }
    }
}
