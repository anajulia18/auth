package com.fiap.auth.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.io.Decoders;

@Component
public class JwtService {


    public static final String SECRET = "fiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiapfiap";


    public void validateToken(final String token) {
        Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token);
    }


    public String generateToken(String userName) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userName);
    }

    private String createToken(Map<String, Object> claims, String userName) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userName)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30))
                .signWith(getSignKey(), SignatureAlgorithm.HS256).compact();
    }

    private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}