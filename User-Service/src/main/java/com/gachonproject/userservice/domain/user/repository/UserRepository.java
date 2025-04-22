package com.gachonproject.userservice.domain.user.repository;

import com.gachonproject.userservice.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsUserByLoginId(String loginId);

    boolean existsUserByStudentId(String studentId);

    Optional<User> findUserByLoginId(String loginId);

}
