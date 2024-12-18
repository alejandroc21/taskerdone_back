package com.alejandroct.taskerdone.service.auth.impl;

import com.alejandroct.taskerdone.dto.UserDTO;
import com.alejandroct.taskerdone.service.auth.IJwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.io.Decoders;


import javax.crypto.SecretKey;
import java.util.Date;
import java.util.function.Function;

@Service
public class JwtServiceImpl implements IJwtService {

    @Value("${token.expiration}")
    private long tokenExpiration;

    @Value("${jwt.secret.key}")
    private String secretKey;

    private SecretKey getSecretKey(){
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(this.secretKey));
    }

    @Override
    public String buildToken(UserDTO userDTO) {
        return Jwts.builder()
                .subject(userDTO.email())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis()+this.tokenExpiration))
                .signWith(this.getSecretKey())
                .compact();
    }

    @Override
    public boolean isTokenValid(String token, UserDetails userDetails) {
        String email = this.extractEmail(token);
        return (email.equals(userDetails.getUsername()) && !this.isTokenExpired(token));
    }

    @Override
    public String extractEmail(String token) {
        return this.getClaims(token, Claims::getSubject);
    }

    private <T> T getClaims(String token, Function<Claims, T> claimsFunction){
        Claims claims = this.getAllClaims(token);
        return claimsFunction.apply(claims);
    }

    private Claims getAllClaims(String token){
        return Jwts.parser()
                .verifyWith(this.getSecretKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    private boolean isTokenExpired(String token){
        return this.getClaims(token, Claims::getExpiration).before(new Date());
    }
}
