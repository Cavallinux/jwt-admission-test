package com.github.cavallinux.jwtadmissiontest.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO para representar una respuesta del login.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginResponseDTO implements Serializable {
    private static final long serialVersionUID = -541842313527247809L;
    private String token;
    private long expiresIn;
}