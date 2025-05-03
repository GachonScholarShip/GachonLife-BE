package com.gachonproject.apigatewayservice.auth.filter;

import com.gachonproject.apigatewayservice.auth.util.JwtError;
import com.gachonproject.apigatewayservice.auth.util.JwtProvider;
import com.netflix.spectator.impl.Config;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Slf4j
@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {

    private final AntPathMatcher pathMatcher = new AntPathMatcher();
    private final JwtProvider jwtProvider;

    // 인증 예외 (모든 사용자 접근 허용)
    private static final List<String> whiteList = List.of(
            "/normal/**", "/signin", "/signup", "/v3/api-docs/**", "/swagger-ui.html", "/swagger-ui/**"
    );

    // USER 접근 허용 경로 (ADMIN도 허용)
    private static final List<String> memberOnlyList = List.of(
            "/member/**"
    );

    // ADMIN만 접근 허용
    private static final List<String> adminOnlyList = List.of(
            "/admin/**", "/image/**"
    );


    public AuthenticationFilter(JwtProvider jwtProvider) {
        super(Config.class);
        this.jwtProvider = jwtProvider;
    }

    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            String path = request.getURI().getPath();

            if (isWhiteListed(path)) {
                return chain.filter(exchange);
            }

            String token = extractToken(request);
            JwtError result = jwtProvider.isJwtValid(token);

            if (!JwtError.PASS.equals(result)) {
                return onError(exchange, result.getMessage(), HttpStatus.UNAUTHORIZED);
            }

            String role = jwtProvider.getRole(token);

            if (!isAuthorized(path, role)) {
                return onError(exchange, JwtError.UN_AUTHORIZED.getMessage(), HttpStatus.FORBIDDEN);
            }

//            ServerHttpRequest mutatedRequest = request.mutate()
//                    .header("userId", jwtProvider.getUserId(token))
//                    .build();

            // 만약 mutatedRequest를 사용한다면 request대신 mutatedRequest를 넣어주자
            return chain.filter(exchange.mutate().request(request).build());
        });
    }


    private boolean isWhiteListed(String path) {
        return whiteList.stream().anyMatch(p -> pathMatcher.match(p, path));
    }

    private boolean isMemberOnly(String path) {
        return memberOnlyList.stream().anyMatch(p -> pathMatcher.match(p, path));
    }

    private boolean isAdminOnly(String path) {
        return adminOnlyList.stream().anyMatch(p -> pathMatcher.match(p, path));
    }

    private boolean isAuthorized(String path, String role) {
        if (isAdminOnly(path)) return role.equals("ADMIN");
        if (isMemberOnly(path)) return role.equals("USER") || role.equals("ADMIN");
        return true;
    }

    private String extractToken(ServerHttpRequest request) {
        List<String> authHeaders = request.getHeaders().getOrEmpty(HttpHeaders.AUTHORIZATION);
        if (authHeaders.isEmpty() || !authHeaders.get(0).startsWith("Bearer ")) {
            return null;
        }
        return authHeaders.get(0).substring(7);
    }

    private Mono<Void> onError(ServerWebExchange exchange, String message, HttpStatus status) {
        log.error(message);

        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(status);

        String errorBody = "{\n \"error\": \"" + message + "\",\n \"status\": " + status.value() + "\n}";
        DataBuffer buffer = response.bufferFactory().wrap(errorBody.getBytes(StandardCharsets.UTF_8));

        return response.writeWith(Mono.just(buffer));
    }

    public static class Config {

    }

}
