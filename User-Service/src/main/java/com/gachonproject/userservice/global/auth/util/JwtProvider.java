package com.gachonproject.userservice.global.auth.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JwtProvider {

    public static final String ACCESS_TOKEN_SUBJECT = "Authorization";
    private static final String ID_CLAIM = "userId";
    private static final String ROLE_CLAIM = "role";
    private static final String ROLE_PREFIX = "ROLE_";
    private final SecretKey key;


    @Value("${gachonlife.auth.jwt.accessTokenExpiration}")
    private Long accessTokenExpiration;

    public JwtProvider(@Value("${gachonlife.auth.jwt.key}") String key) {
        this.key = new SecretKeySpec(
                key.getBytes(StandardCharsets.UTF_8),
                Jwts.SIG.HS256.key().build().getAlgorithm()
        );
    }

    public String generateAccessToken(Long userId, String role) {
        return Jwts.builder()
                .claim(ID_CLAIM, userId)
                .claim(ROLE_CLAIM, role)
                .setSubject(ACCESS_TOKEN_SUBJECT) // 사용자 정보(고유 식별자)
                .setIssuedAt(new Date()) // 발행 시간
                .setExpiration(new Date(System.currentTimeMillis() + accessTokenExpiration)) // 만료 시간
                .signWith(key, SignatureAlgorithm.HS256) // 서명 알고리즘
                .compact(); // 최종 문자열 생성
    }

}
