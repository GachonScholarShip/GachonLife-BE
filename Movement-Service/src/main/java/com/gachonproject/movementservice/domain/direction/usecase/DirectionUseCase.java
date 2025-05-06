package com.gachonproject.movementservice.domain.direction.usecase;

import com.gachonproject.movementservice.domain.direction.dto.request.DirectionSaveDto;
import com.gachonproject.movementservice.domain.direction.dto.request.DirectionUpdateDto;
import com.gachonproject.movementservice.domain.direction.dto.response.DirectionDetailDto;
import com.gachonproject.movementservice.domain.direction.entity.Direction;
import com.gachonproject.movementservice.domain.direction.repository.DirectionRepository;
import com.gachonproject.movementservice.domain.direction.service.DirectionDeleteService;
import com.gachonproject.movementservice.domain.direction.service.DirectionGetService;
import com.gachonproject.movementservice.domain.direction.service.DirectionSaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DirectionUseCase {

    private final DirectionGetService directionGetService;
    private final DirectionSaveService directionSaveService;
    private final DirectionDeleteService directionDeleteService;

    public void saveDirection(DirectionSaveDto dto) {
        directionGetService.checkDuplicatedEndPoint(dto.endPoint());
        directionSaveService.save(dto);
    }

}
