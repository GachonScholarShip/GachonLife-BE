package com.gachonproject.userservice.domain.user.service;

import com.gachonproject.userservice.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserGetService {

    private final UserRepository userRepository;

    public boolean validateLoginId(String loginId) {
        return userRepository.existsUserByLoginId(loginId);
    }


}
