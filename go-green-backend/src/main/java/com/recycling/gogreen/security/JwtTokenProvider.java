package com.recycling.gogreen.security;

import com.recycling.gogreen.exception.GoGreenAPIException;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtTokenProvider implements Serializable {

    private static final long serialVersionUUID = 1L;

    @Value("${app.jwt-expiration-milliseconds}")
    private long jwtTokenExpiration;

    @Value("${app.jwt-secret}")
    private String jwtSecret;

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Key key() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parserBuilder().setSigningKey(key()).build().parseClaimsJws(token).getBody();
    }

    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    public Date getIssuedAtDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getIssuedAt);
    }

    public Date getExpirationFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    private boolean isTokenExpired(String token) {
        final Date expiration = getExpirationFromToken(token);
        return expiration.before(new Date());
    }

    public String generateToken(Authentication authentication) {
        Map<String, Object> claims = new HashMap<>();
        return doGenerateToken(claims, authentication.getName());
    }

    public String doGenerateToken(Map<String, Object> claims, String subject) {
        Date current = new Date();
        Date expiration = new Date(current.getTime() + jwtTokenExpiration);
        String jwtToken = Jwts.builder().setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(current)
                .setExpiration(expiration)
                .signWith(key()).compact();
        return jwtToken;
    }

    public boolean canTokenBeRefreshed(String token) {
        return !isTokenExpired(token);
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key()).build().parse(token);
            return true;
        } catch (IllegalArgumentException ex) {
            throw new GoGreenAPIException(HttpStatus.BAD_REQUEST, "Unable to get JWT token");
        } catch (ExpiredJwtException ex) {
            throw new GoGreenAPIException(HttpStatus.BAD_REQUEST, "JWT token expired");
        } catch (UnsupportedJwtException ex) {
            throw new GoGreenAPIException(HttpStatus.BAD_REQUEST, "Unsupported JWT token");
        } catch (MalformedJwtException ex) {
            throw new GoGreenAPIException(HttpStatus.BAD_REQUEST, "Invalid JWT token");
        }
    }

}
