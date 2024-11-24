package com.devEmersonc.gestion_de_inventarios.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json");

        Map<String, Object> errorsDetails = new HashMap<>();

        errorsDetails.put("status", HttpServletResponse.SC_UNAUTHORIZED);
        errorsDetails.put("error", "Error de autenticación.");
        errorsDetails.put("message", authException.getMessage() != null ? authException.getMessage() : "Error de autenticación. Por favor vuelve a iniciar sesión.");
        errorsDetails.put("timestamp", LocalDateTime.now().toString());
        errorsDetails.put("path", request.getRequestURI());

        response.getWriter().write(objectMapper.writeValueAsString(errorsDetails));
    }
}
