package com.gachonproject.movementservice.domain.direction.service;

import com.gachonproject.movementservice.domain.direction.dto.request.DirectionSaveDto;
import com.gachonproject.movementservice.domain.direction.entity.Direction;
import com.gachonproject.movementservice.domain.direction.repository.DirectionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DirectionSaveService {

    private final DirectionRepository directionRepository;

    public void save(DirectionSaveDto dto) {
        directionRepository.save(Direction.from(dto));
    }

}
