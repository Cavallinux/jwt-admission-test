package com.github.cavallinux.jwtadmissiontest.controller;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.cavallinux.jwtadmissiontest.dto.CreateUserDTO;
import com.github.cavallinux.jwtadmissiontest.dto.UserDTO;
import com.github.cavallinux.jwtadmissiontest.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

/**
 * Controlador para manejar las solicitudes relacionadas con los usuarios del sistema.
 */
@Log4j2
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService usuarioService;

    /**
     *
     * @return
     */
    @GetMapping
    public List<UserDTO> getAllUsuarios() {
        return usuarioService.getAllUsuarios();
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUsuarioById(@PathVariable Long id) {
        return usuarioService.getUsuarioById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     *
     * @param usuario
     * @return
     */
    @PostMapping("/register")
    public UserDTO createUsuario(@RequestBody CreateUserDTO usuario) {
        return usuarioService.createUsuario(usuario);
    }

    /**
     *
     * @param id
     * @param usuario
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUsuario(@PathVariable Long id, @RequestBody UserDTO usuario) {
        return usuarioService.updateUsuario(id, usuario)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
        if (usuarioService.deleteUsuario(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}