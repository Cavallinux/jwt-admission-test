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
public class CreateUserDTO implements Serializable {
    private static final long serialVersionUID = 215464085630683051L;
    private String nombre;
    private String correo;
    private String contrasena;
    private List<PhoneDTO> telefonos;
}