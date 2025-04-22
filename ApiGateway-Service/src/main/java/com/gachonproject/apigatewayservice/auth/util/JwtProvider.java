package com.gachonproject.apigatewayservice.auth.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.WeakKeyException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JwtProvider {

    public static final String ACCESS_TOKEN_SUBJECT = "Authorization";
    private static final String ID_CLAIM = "id";
    private static final String ROLE_CLAIM = "role";
    private final SecretKey key;


    @Value("${gachonlife.auth.jwt.accessTokenExpiration}")
    private Long accessTokenExpiration;

    public JwtProvider(@Value("${gachonlife.auth.jwt.key}") String key) {
        this.key = new SecretKeySpec(
                key.getBytes(StandardCharsets.UTF_8),
                Jwts.SIG.HS256.key().build().getAlgorithm()
        );
    }

    public String generateAccessToken(Long id, String role) {
        return Jwts.builder()
                .claim(ID_CLAIM, id)
                .claim(ROLE_CLAIM, role)
                .setSubject(ACCESS_TOKEN_SUBJECT) // 사용자 정보(고유 식별자)
                .setIssuedAt(new Date()) // 발행 시간
                .setExpiration(new Date(System.currentTimeMillis() + accessTokenExpiration)) // 만료 시간
                .signWith(key, SignatureAlgorithm.HS256) // 서명 알고리즘
                .compact(); // 최종 문자열 생성
    }

    public String getRole(String token) {
        return Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload().get("role", String.class);
    }

    public Long getUserId(String token) {
        return Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload().get("userId", Long.class);
    }

    public JwtError isJwtValid(String token) {
        JwtError jwtError = JwtError.PASS;

        try {
            Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload();
        } catch (ExpiredJwtException e) {
            return JwtError.EXPIRED_JWT;
        } catch (UnsupportedJwtException e) {
            return JwtError.UN_SUPPORTED_JWT;
        } catch (MalformedJwtException e) {
            return JwtError.MALFORMED_JWT;
        } catch (SignatureException e) {
            return JwtError.SIGNATURE_JWT;
        } catch (IllegalArgumentException e) {
            return JwtError.ILLEGAL_ARGUMENT;
        } catch (WeakKeyException e) {
            return JwtError.WEAK_KEY;
        } catch (Exception e) {
            return JwtError.CAUSE_UNKNOWN;
        }

        return jwtError;
    }

}