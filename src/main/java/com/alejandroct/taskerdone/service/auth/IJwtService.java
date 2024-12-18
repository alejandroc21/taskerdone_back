package com.alejandroct.taskerdone.service.auth;

import com.alejandroct.taskerdone.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetails;

public interface IJwtService {
    String buildToken(UserDTO userDTO);

    boolean isTokenValid(String token, UserDetails userDetails);

    String extractEmail(String token);
}
