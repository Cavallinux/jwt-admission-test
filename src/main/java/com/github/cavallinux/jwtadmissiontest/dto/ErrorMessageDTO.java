package com.github.cavallinux.jwtadmissiontest.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

/**
 * Representacion del mensaje de error a entregar.
 */
@Data
@Builder
public class ErrorMessageDTO implements Serializable {
    private static final long serialVersionUID = -700871970550452046L;
    private String mensaje;
}