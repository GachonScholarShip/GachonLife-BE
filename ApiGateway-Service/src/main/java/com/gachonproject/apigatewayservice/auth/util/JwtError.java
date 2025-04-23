package com.gachonproject.apigatewayservice.auth.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum JwtError {

    UN_AUTHORIZED("잘못된 권한 요청입니다."),
    NOT_EXIST_TOKEN("JWT 토큰이 존재하지 않습니다."),
    EXPIRED_JWT("JWT 토큰이 만료되었습니다."),
    UN_SUPPORTED_JWT("지원되지 않는 JWT 토큰입니다."),
    MALFORMED_JWT("잘못된 형식의 JWT 토큰입니다."),
    SIGNATURE_JWT("JWT 서명 검증에 실패했습니다."),
    ILLEGAL_ARGUMENT("잘못된 JWT 토큰입니다."),
    WEAK_KEY("JWT 서명 KEY가 너무 약합니다."),
    CAUSE_UNKNOWN("원인 미상의 오류가 발생했습니다."),
    PASS("유효한 Jwt 토큰");

    private final String message;
}
