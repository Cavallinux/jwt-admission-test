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
public class PhoneDTO implements Serializable {
    private static final long serialVersionUID = 1721404807092653006L;
    private String numero;
    private String codigoCiudad;
    private String codigoPais;
}