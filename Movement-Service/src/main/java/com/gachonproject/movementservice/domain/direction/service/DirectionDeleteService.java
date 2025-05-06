package com.gachonproject.movementservice.domain.direction.service;

import com.gachonproject.movementservice.domain.direction.entity.Direction;
import com.gachonproject.movementservice.domain.direction.repository.DirectionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DirectionDeleteService {

    private final DirectionRepository directionRepository;

    public void delete(Direction direction) {
        directionRepository.delete(direction);
    }

}
