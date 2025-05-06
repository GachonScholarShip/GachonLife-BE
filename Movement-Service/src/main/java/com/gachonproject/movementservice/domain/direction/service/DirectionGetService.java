package com.gachonproject.movementservice.domain.direction.service;


import com.gachonproject.movementservice.domain.direction.entity.Direction;
import com.gachonproject.movementservice.domain.direction.exception.DirectionNotFoundException;
import com.gachonproject.movementservice.domain.direction.exception.DuplicatedDirectionEndPointException;
import com.gachonproject.movementservice.domain.direction.repository.DirectionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DirectionGetService {

    private final DirectionRepository directionRepository;

    public void checkDuplicatedEndPoint(String endPoint) {
        if (directionRepository.existsByEndPoint(endPoint)) {
            // 존재하면 예외 처리
            throw new DuplicatedDirectionEndPointException();
        }
    }

    public List<Direction> getDirectionList(Pageable pageable) {
        return directionRepository.findAll(pageable).getContent();
    }


    public Direction getDirection(String endPoint) {
        return directionRepository.findByEndPoint(endPoint)
                .orElseThrow(DirectionNotFoundException::new);
    }

    public Direction getDirectionById(Long id) {
        return directionRepository.findById(id)
                .orElseThrow(DirectionNotFoundException::new);
    }
}
