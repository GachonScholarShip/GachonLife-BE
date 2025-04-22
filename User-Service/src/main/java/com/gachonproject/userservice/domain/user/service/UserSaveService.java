package com.gachonproject.userservice.domain.user.service;

import com.gachonproject.userservice.domain.user.entity.User;
import com.gachonproject.userservice.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class UserSaveService {

    private final UserRepository userRepository;

    public void save(User user) {
        userRepository.save(user);
    }
}
