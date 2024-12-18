package com.alejandroct.taskerdone.controller.auth;

import com.alejandroct.taskerdone.dto.auth.LoginRequest;
import com.alejandroct.taskerdone.dto.auth.RegisterRequest;
import com.alejandroct.taskerdone.dto.auth.TokenResponse;
import com.alejandroct.taskerdone.service.auth.IAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final IAuthService authService;

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@RequestBody LoginRequest request){
        return ResponseEntity.ok(this.authService.authenticate(request));
    }

    @PostMapping("register")
    public ResponseEntity<TokenResponse> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(this.authService.register(request));
    }
}
