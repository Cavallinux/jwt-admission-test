package com.github.cavallinux.jwtadmissiontest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.cavallinux.jwtadmissiontest.dto.LoginDTO;
import com.github.cavallinux.jwtadmissiontest.dto.LoginResponseDTO;
import com.github.cavallinux.jwtadmissiontest.entity.UserEntity;
import com.github.cavallinux.jwtadmissiontest.service.AuthenticationService;
import com.github.cavallinux.jwtadmissiontest.service.JwtService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

/**
 * Controlador de autenticacion
 */
@Log4j2
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final JwtService jwtService;
    private final AuthenticationService authenticationService;

    /**
     * Autentica a un usuario
     * @param loginUserDto DTO con username y password
     * @return Respuesta de autenticacion con token JWT
     */
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> authenticate(@RequestBody LoginDTO loginUserDto) {
        UserEntity authenticatedUser = authenticationService.authenticate(loginUserDto);
        LoginResponseDTO loginResponse = LoginResponseDTO.builder().token(authenticatedUser.getToken()).expiresIn(jwtService.getExpirationTime()).build();
        return ResponseEntity.ok(loginResponse);
    }

}


