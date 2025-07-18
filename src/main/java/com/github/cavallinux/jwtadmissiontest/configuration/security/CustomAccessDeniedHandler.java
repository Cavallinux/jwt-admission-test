package com.github.cavallinux.jwtadmissiontest.configuration.security;

import java.io.IOException;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;


/**
 * @author Franco
 */
@Slf4j
@Component
@AllArgsConstructor
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    private final HandlerExceptionResolver handlerExceptionResolver;


    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws IOException, ServletException {

        handlerExceptionResolver.resolveException(request, response, null, accessDeniedException);

    }

}
