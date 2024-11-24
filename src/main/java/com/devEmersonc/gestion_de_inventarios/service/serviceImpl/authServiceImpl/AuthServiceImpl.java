package com.devEmersonc.gestion_de_inventarios.service.serviceImpl.authServiceImpl;

import com.devEmersonc.gestion_de_inventarios.dto.AuthRequest;
import com.devEmersonc.gestion_de_inventarios.dto.AuthResponse;
import com.devEmersonc.gestion_de_inventarios.service.authService.AuthService;
import com.devEmersonc.gestion_de_inventarios.service.CustomUserDetailsService;
import com.devEmersonc.gestion_de_inventarios.service.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final CustomUserDetailsService customUserDetailsService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthServiceImpl(CustomUserDetailsService customUserDetailsService, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.customUserDetailsService = customUserDetailsService;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public AuthResponse loging(AuthRequest authRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
        );

        UserDetails userDetails = customUserDetailsService.loadUserByUsername(authRequest.getUsername());
        String token = jwtService.generateToken(userDetails);
        return new AuthResponse(token);
    }
}
