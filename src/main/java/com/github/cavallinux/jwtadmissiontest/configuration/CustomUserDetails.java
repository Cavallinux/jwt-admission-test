package com.github.cavallinux.jwtadmissiontest.configuration;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.github.cavallinux.jwtadmissiontest.entity.UserEntity;

import lombok.Data;

@Data
public class CustomUserDetails implements UserDetails {
    private static final long serialVersionUID = -6330279555425606498L;
    private String username;
    private List<GrantedAuthority> authorities;
    private String password;

    public CustomUserDetails(UserEntity user) {
        this.username = user.getCorreo();
        this.password = user.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }

}