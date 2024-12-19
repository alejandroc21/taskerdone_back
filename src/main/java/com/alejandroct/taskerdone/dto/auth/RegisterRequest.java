package com.alejandroct.taskerdone.dto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record RegisterRequest(
        @NotBlank(message = "name can't be empty")
        String name,
        @NotBlank(message = "email can't be empty")
        @Email(message = "you need a valid email format")
        String email,
        @NotBlank(message = "password can't be empty")
        String password
) {
}
