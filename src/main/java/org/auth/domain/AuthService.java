package org.auth.domain;

import org.auth.dto.JwtAuthResponse;
import org.auth.dto.LoginReq;
import org.auth.dto.RegisterReq;
import org.auth.exceptions.UserAlreadyExistException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.user.domain.User;
import org.user.infrastructure.UserRepository;
import org.config.JwtService;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;

    public AuthService(UserRepository userRepository, JwtService jwtService) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }

    public JwtAuthResponse login(LoginReq req){
        User user = userRepository.findByEmail(req.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        if (!req.getPassword().equals(user.getPassword()))
            throw new IllegalArgumentException("Password is incorrect");

        String token = jwtService.generateToken(user);

        return new JwtAuthResponse(token);
    }

    public JwtAuthResponse register(RegisterReq req){
        if (userRepository.existsByEmail(req.getEmail()))
            throw new UserAlreadyExistException("Email is already registered");

        User user = new User();
        user.setEmail(req.getEmail());
        user.setPassword(req.getPassword()); // Make sure to hash the password before saving
        userRepository.save(user);

        String token = jwtService.generateToken(user);

        return new JwtAuthResponse(token);
    }
}