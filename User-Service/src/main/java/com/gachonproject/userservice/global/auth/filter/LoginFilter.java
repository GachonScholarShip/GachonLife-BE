package com.gachonproject.userservice.global.auth.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gachonproject.userservice.global.auth.dto.LoginRequest;
import com.gachonproject.userservice.global.auth.jwt.CustomUserDetails;
import com.gachonproject.userservice.global.auth.util.JwtProvider;
import com.gachonproject.userservice.global.common.response.ApiResponse;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

@Slf4j
public class LoginFilter extends UsernamePasswordAuthenticationFilter {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;


    public LoginFilter(AuthenticationManager authenticationManager, JwtProvider jwtProvider) {
        this.authenticationManager = authenticationManager;
        this.jwtProvider = jwtProvider;
        setFilterProcessesUrl("/signin");
//        setUsernameParameter("loginId");
    }

    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        try {

            LoginRequest dto = objectMapper.readValue(request.getInputStream(), LoginRequest.class);

            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.loginId(), dto.password(), null));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException {

        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        Long userId = userDetails.getUserId();
        String userRole = getUserRole(authentication);

        String accessToken = jwtProvider.generateAccessToken(userId, userRole);

//        ApiResponse

        response.addHeader("Authorization", "Bearer " + accessToken);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.setStatus(HttpStatus.OK.value());

        response.getWriter().write(new ObjectMapper().writeValueAsString(
                ApiResponse.response(HttpStatus.OK, "로그인 성공!"))
        );
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        log.info("unsuccessfulAuthentication 실행");

        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setCharacterEncoding("UTF-8");      // 한글 설정
        response.setContentType("application/json"); // 응답을 JSON으로

        response.getWriter().write(new ObjectMapper().writeValueAsString(
                ApiResponse.response(HttpStatus.UNAUTHORIZED, "로그인 실패")
        ));
    }

    private String getUserRole(Authentication authentication) {
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        Iterator<? extends GrantedAuthority> iterator = authorities.iterator();
        GrantedAuthority auth = iterator.next();
        return  auth.getAuthority();
    }
}
