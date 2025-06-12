package com.github.cavallinux.jwtadmissiontest.service;

import java.time.LocalDateTime;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.github.cavallinux.jwtadmissiontest.configuration.CustomUserDetails;
import com.github.cavallinux.jwtadmissiontest.dto.LoginDTO;
import com.github.cavallinux.jwtadmissiontest.entity.UserEntity;
import com.github.cavallinux.jwtadmissiontest.repository.UserRepository;

import lombok.RequiredArgsConstructor;

/**
 * Servicio para manejar la lógica de la autenticacion del usuario
 */
@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    /**
     * @param input
     * @return
     */
    public UserEntity authenticate(LoginDTO input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getCorreo(),
                        input.getContrasena()
                )
        );

        UserEntity user = userRepository.findByCorreo(input.getCorreo())
                .orElseThrow();
        user.setUltimoLogin(LocalDateTime.now());
        user.setToken(jwtService.generateToken(new CustomUserDetails(user)));
        userRepository.save(user);
        return user;
    }

}