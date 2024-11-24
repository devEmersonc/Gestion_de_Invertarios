package com.devEmersonc.gestion_de_inventarios.service.authService;

import com.devEmersonc.gestion_de_inventarios.dto.AuthRequest;
import com.devEmersonc.gestion_de_inventarios.dto.AuthResponse;

public interface AuthService {
    AuthResponse loging(AuthRequest authRequest);
}
