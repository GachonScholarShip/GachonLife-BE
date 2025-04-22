package com.gachonproject.userservice.domain.user.repository;

import com.gachonproject.userservice.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
