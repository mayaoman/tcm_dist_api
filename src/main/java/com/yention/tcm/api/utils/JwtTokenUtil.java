package com.yention.tcm.api.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import com.yention.tcm.api.domains.JwtUserDetails;
import java.io.UnsupportedEncodingException;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class JwtTokenUtil implements Serializable {

    @Value("${jwt.expiration}")
    private Long tokenExpiration;

    @Autowired
    private String base64SecretKey;

    @Autowired
    private SignatureAlgorithm signAlgorithmHS256;
    

    private String generateToken(String subject, Map<String, Object> claims) {
        Date expirationDate = new Date(System.currentTimeMillis() + tokenExpiration * 1000);
        
        return Jwts.builder()
                   .setSubject(subject)
                   .setClaims(claims)
                   .setExpiration(expirationDate)
                   .signWith(signAlgorithmHS256, base64SecretKey)
                   .compact();
    }

    public String generateToken(JwtUserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>(2);
        claims.put("username", userDetails.getUsername());
        claims.put("created", new Date());
        return generateToken(userDetails.getId(),claims);
    }

    private Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser().setSigningKey(base64SecretKey).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }


    public String getUsernameFromToken(String token) {
        String username;
        try {
            Claims claims = getClaimsFromToken(token);
            // username = claims.getSubject();
            username = claims.get("username").toString();
        } catch (Exception e) {
            username = null;
        }
        return username;
    }

    public Boolean isTokenExpired(String token) {
        try {
            Claims claims = getClaimsFromToken(token);
            Date expiration = claims.getExpiration();
            return expiration.before(new Date());
        } catch (Exception e) {
            return false;
        }
    }

    public String refreshToken(String token) {
        String refreshedToken;
        try {
            Claims claims = getClaimsFromToken(token);
            claims.put("created", new Date());
            refreshedToken = generateToken(claims.getSubject(), claims);
        } catch (Exception e) {
            refreshedToken = null;
        }
        return refreshedToken;
    }


    public Boolean validateToken(String token, UserDetails userDetails) {
        // JwtUserDetails user = (JwtUserDetails) userDetails;
        String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

}