package com.atilas.genshin.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {
    @Value("${SECRETE_KEY}")
    private String secret;

    @Value("${EXPIRATION_TIME}")
    private Integer expiration;

    // retorna um token jwt
    public String getJWT(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return Jwts.builder().setClaims(claims).setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                // apenas secrete
                .signWith(SignatureAlgorithm.HS256, secret).compact();
    }

    // verifica a validade de um token
    public Boolean isTokenValid(String token, UserDetails userDetails) {
        final String userName = extractClaim(token, Claims::getSubject);
        return (userName).equals(userDetails.getUsername())
                && !extractClaim(token, Claims::getExpiration).before(new Date());
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        claimsResolver.apply(claims);
        return claimsResolver.apply(claims);
    }
}
