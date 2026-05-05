package com.jobacademy.mvp.services;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.jobacademy.mvp.model.Rol;
import com.jobacademy.mvp.model.User;
import com.jobacademy.mvp.repository.UserRepository;
import com.jobacademy.mvp.security.JwtService;

@Service
public class AuthService {

    private final UserRepository repo;
    private final PasswordEncoder encoder;
    private final JwtService jwtService;

    public AuthService(UserRepository repo, PasswordEncoder encoder, JwtService jwtService) {
        this.repo = repo;
        this.encoder = encoder;
        this.jwtService = jwtService;
    }

    public String register(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        user.setRol(Rol.USER);

        repo.save(user);

        return jwtService.generateToken(user);
    }

    public String login(String email, String password) {

        User user = repo.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));

        if (!encoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Password error");
        }

        return jwtService.generateToken(user);
    }
}
