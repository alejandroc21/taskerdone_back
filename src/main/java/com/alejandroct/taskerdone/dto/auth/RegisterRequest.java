package com.alejandroct.taskerdone.dto.auth;

public record RegisterRequest(
        String name,
        String email,
        String password
) {
}
