package com.alejandroct.taskerdone.service.auth.impl;

import com.alejandroct.taskerdone.constants.ExceptionMessages;
import com.alejandroct.taskerdone.dto.auth.LoginRequest;
import com.alejandroct.taskerdone.dto.auth.RegisterRequest;
import com.alejandroct.taskerdone.dto.auth.TokenResponse;
import com.alejandroct.taskerdone.model.User;
import com.alejandroct.taskerdone.service.IUserService;
import com.alejandroct.taskerdone.service.auth.IAuthService;
import com.alejandroct.taskerdone.service.auth.IJwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements IAuthService {
    private final IJwtService jwtService;
    private final IUserService userService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Override
    public TokenResponse authenticate(LoginRequest request) {
        this.authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.email(), request.password())
        );
        String token = this.jwtService.buildToken(this.userService.findUserDTObyEmail(request.email()));
        return new TokenResponse(token);
    }

    @Override
    public TokenResponse register(RegisterRequest request) {
        if(this.userService.userExist(request.email())){
            throw new IllegalArgumentException(ExceptionMessages.EMAIL_IN_USE);
        }
        User user = User.builder()
                .name(request.name())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .build();

        String token = this.jwtService.buildToken(this.userService.saveUser(user));
        return new TokenResponse(token);
    }
}
