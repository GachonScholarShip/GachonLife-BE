package com.gachonproject.userservice.domain.user.service;

import com.gachonproject.userservice.domain.user.entity.User;
import com.gachonproject.userservice.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDeleteService {

    private final UserRepository userRepository;

    public void delete(User user) {
        userRepository.delete(user);
    }
}
