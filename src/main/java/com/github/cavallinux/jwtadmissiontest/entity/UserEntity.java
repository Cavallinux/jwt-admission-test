package com.github.cavallinux.jwtadmissiontest.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name="users")
public class UserEntity extends AutoincrementEntity {
    private static final long serialVersionUID = 2057883949344548687L;
    @Column(unique = true)
    private String correo;
    @Column
    private String password;
    @Column
    private String token;
    @Column
    private Boolean activo;
    @Column
    private LocalDateTime ultimoLogin;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PhoneEntity> telefonos;
}
