package com.alejandroct.taskerdone.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        if(request.getAttribute("expired") !=null){
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        }else {
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
        }
    }
}
