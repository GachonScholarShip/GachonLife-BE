package com.gachonproject.userservice.global.auth.jwt;

import com.gachonproject.userservice.domain.user.entity.User;
import com.gachonproject.userservice.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User findUser = userRepository.findUserByLoginId(username).orElse(null);

        if (findUser != null) {
            return new CustomUserDetails(findUser);
        }

        log.info("LoadUserByUsername 로그인 실패(옳지 않은 ID인 경우)");
        throw new UsernameNotFoundException("사용자를 찾을 수 없습니다.");
    }
}
