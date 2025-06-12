package com.github.cavallinux.jwtadmissiontest.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

/**
 * Representacion del json de error requerido en la prueba
 */
@Data
@Builder
public class ErrorMessageDTO implements Serializable {

    private String mensaje;

}
