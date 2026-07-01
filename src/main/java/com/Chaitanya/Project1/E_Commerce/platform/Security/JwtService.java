package com.Chaitanya.Project1.E_Commerce.platform.Security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.function.Function;

@Service
public class JwtService {
    private static final String SECRET_KEY= "ZmY4YjQ2MjI0YzY1YTI2N2Q1MjY0ZTRjN2Q2YzA4ZGE3N2MzYzY4YjIyZDA3YmRiYjA3ZjQ5N2YzYzA3NQ==";

    public String generateToken(UserDetails userDetails)
    {
        return Jwts.builder()
                .subject(userDetails.getUsername())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis()+1000*60*60*24))
                .signWith(getSignInKey())
                .compact();
    }
    public String extractUsername(String token)
    {
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims,T> claimsResolver)
    {
        Claims claims=extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    private Claims extractAllClaims(String token)
    {
        return Jwts.parser()
                .verifyWith(getSignInKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();

    }
    public boolean isTokenValid(String token,UserDetails userDetails)
    {
        String username=extractUsername(token);
        return username.equals(userDetails.getUsername())
                &&!isTokenExpired(token);
    }

    private boolean isTokenExpired(String token)
    {
        return extractClaim(token,Claims::getExpiration)
                .before(new Date());
    }
    private SecretKey getSignInKey()
    {
        byte[] keyBytes= Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }


}
