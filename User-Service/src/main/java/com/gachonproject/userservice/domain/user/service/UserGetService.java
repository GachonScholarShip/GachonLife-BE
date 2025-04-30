package com.gachonproject.userservice.domain.user.service;

import com.gachonproject.userservice.domain.user.entity.User;
import com.gachonproject.userservice.domain.user.exception.UserNotFoundException;
import com.gachonproject.userservice.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserGetService {

    private final UserRepository userRepository;

    public boolean validateLoginId(String loginId) {
        return userRepository.existsUserByLoginId(loginId);
    }

    public boolean validateStudentId(String studentId) {
        return userRepository.existsUserByStudentId(studentId);
    }

    public User findByUserId(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(UserNotFoundException::new);
    }

    public List<User> findUserList(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        return userRepository.findAll(pageable).getContent();
    }


}
