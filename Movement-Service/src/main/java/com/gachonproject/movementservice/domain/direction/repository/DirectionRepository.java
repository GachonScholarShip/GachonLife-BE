package com.gachonproject.movementservice.domain.direction.repository;

import com.gachonproject.movementservice.domain.direction.entity.Direction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DirectionRepository extends JpaRepository<Direction, Long> {

    boolean existsByEndPoint(String endPoint);

    Optional<Direction> findByEndPoint(String endPoint);

}
