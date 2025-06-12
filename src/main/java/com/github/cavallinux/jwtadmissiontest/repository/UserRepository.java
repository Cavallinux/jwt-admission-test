package com.github.cavallinux.jwtadmissiontest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.cavallinux.jwtadmissiontest.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByCorreo(String correo);

}
