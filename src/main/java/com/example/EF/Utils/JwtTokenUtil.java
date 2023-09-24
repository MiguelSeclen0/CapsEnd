package com.example.EF.Utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTokenUtil {

    private static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private static final long EXPIRATION_TIME = 3600000; // 1 hora en milisegundos

    public static String generateAuthToken(String email) {
        // Crear claims personalizados para el token
        Map<String, Object> claims = new HashMap<>();
        claims.put("email", email);

        // Fecha de expiración del token (1 hora a partir de ahora)
        Date expirationDate = new Date(System.currentTimeMillis() + EXPIRATION_TIME);

        // Generar el token JWT
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(email)
                .setExpiration(expirationDate)
                .signWith(SECRET_KEY)
                .compact();
    }
}

