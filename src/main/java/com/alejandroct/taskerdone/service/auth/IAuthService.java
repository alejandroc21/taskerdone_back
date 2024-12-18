package com.alejandroct.taskerdone.service.auth;

import com.alejandroct.taskerdone.dto.auth.LoginRequest;
import com.alejandroct.taskerdone.dto.auth.RegisterRequest;
import com.alejandroct.taskerdone.dto.auth.TokenResponse;

public interface IAuthService {
    TokenResponse authenticate(LoginRequest request);

    TokenResponse register(RegisterRequest request);
}
