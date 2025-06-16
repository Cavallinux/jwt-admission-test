package com.github.cavallinux.jwtadmissiontest.exception;

public class PasswordException extends RuntimeException{
    private static final long serialVersionUID = -6624605431039554462L;

    public PasswordException(String message) {
        super(message);
    }
}
