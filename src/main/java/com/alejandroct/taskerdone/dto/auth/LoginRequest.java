package com.alejandroct.taskerdone.dto.auth;

public record LoginRequest(
        String email,
        String password
) {}
