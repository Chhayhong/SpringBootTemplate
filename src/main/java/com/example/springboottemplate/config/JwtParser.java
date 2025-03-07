package com.example.springboottemplate.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;


@Component
@RequiredArgsConstructor
public class JwtParser {

    @Value("${jwt.token.secret}")
    protected String jwtTokenSecret;

    public Claims getClaims(String jwtToken) {
        return Jwts.parser()
                .verifyWith(Keys.hmacShaKeyFor(jwtTokenSecret.getBytes(StandardCharsets.UTF_8)))
                .build()
                .parseSignedClaims(jwtToken)
                .getPayload();

    }
}
