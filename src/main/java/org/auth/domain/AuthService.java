package org.auth.domain;

import org.auth.dto.JwtAuthResponse;
import org.auth.dto.LoginReq;
import org.auth.dto.RegisterReq;
import org.auth.exceptions.UserAlreadyExistException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.user.domain.User;
import org.user.infraestructure.UserRepository;
import org.config.JwtService;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository usuarioRepository;
    private final LoginRepository loginRepository;
    private final JwtService jwtService;

    public AuthService(UserRepository usuarioRepository, LoginRepository loginRepository, JwtService jwtService) {
        this.usuarioRepository = usuarioRepository;
        this.loginRepository = loginRepository;
        this.jwtService = jwtService;
    }

    public JwtAuthResponse login(LoginReq req) {
        Login login = loginRepository.findByEmail(req.getEmail())
                .orElseThrow(() -> new UserAlreadyExistException("Email is not registered"));

        if (!req.getPassword().equals(login.getPassword()))
            throw new IllegalArgumentException("Password is incorrect");

        User usuario = usuarioRepository.findById(login.getIdUsuario())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        JwtAuthResponse response = new JwtAuthResponse();
        response.setToken(jwtService.generateToken(usuario));
        return response;
    }

    public JwtAuthResponse register(RegisterReq req){
        if (loginRepository.existsByEmail(req.getEmail()))
            throw new UserAlreadyExistException("Email is already registered");

        User usuario = new User();
        usuario.setNombre(req.getFirstName());
        usuario.setApellido(req.getLastName());
        usuarioRepository.save(usuario);

        Login login = new Login();
        login.setEmail(req.getEmail());
        login.setPassword(req.getPassword());
        login.setIdUsuario(usuario.getIdUsuario());
        loginRepository.save(login);

        JwtAuthResponse response = new JwtAuthResponse();
        response.setToken(jwtService.generateToken(usuario));
        return response;
      Apellido(req.getLastName());

    }
}