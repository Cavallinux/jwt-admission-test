package com.github.cavallinux.jwtadmissiontest.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginDTO implements Serializable {
    private static final long serialVersionUID = -2433318936243114515L;
    private String correo;
    private String contrasena;
}