package com.example.springboottemplate.config;

import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;

@Slf4j
@Configuration
public class JwtSecurityTokenConfiguration {

    @Value("${jwt.token.secret}")
    private String jwtTokenSecret;

    public SecretKey getSecretKey() {
        return Keys.hmacShaKeyFor(jwtTokenSecret.getBytes(StandardCharsets.UTF_8));
    }
}