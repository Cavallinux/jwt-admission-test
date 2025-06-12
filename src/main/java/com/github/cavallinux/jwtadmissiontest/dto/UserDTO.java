package com.github.cavallinux.jwtadmissiontest.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO implements Serializable {

    private Long id;
    private String creado;
    private String correo;
    private String contrasena;
    private String ultimoLogin;
    private String token;
    private Boolean activo;
    private List<PhoneDTO> telefonos;
}
