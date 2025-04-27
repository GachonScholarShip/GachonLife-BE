package com.gachonproject.movementservice.domain.mudang.repository;

import com.gachonproject.movementservice.domain.mudang.entity.Mudang;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MudangRepository extends JpaRepository<Mudang, Long> {
}
