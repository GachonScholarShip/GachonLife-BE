package com.gachonproject.movementservice.domain.direction.controller;

import com.gachonproject.movementservice.domain.direction.dto.request.DirectionSaveDto;
import com.gachonproject.movementservice.domain.direction.dto.request.DirectionUpdateDto;
import com.gachonproject.movementservice.domain.direction.dto.response.DirectionDetailDto;
import com.gachonproject.movementservice.domain.direction.usecase.DirectionUseCase;
import com.gachonproject.movementservice.global.common.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.gachonproject.movementservice.domain.direction.controller.enums.SuccessMessage.*;

@RestController
@RequiredArgsConstructor
public class DirectionController {

    private final DirectionUseCase directionUseCase;

    @PostMapping("/admin/direction")
    public ApiResponse<Void> save(@RequestBody DirectionSaveDto dto) {

        directionUseCase.saveDirection(dto);

        return ApiResponse.response(HttpStatus.OK, DIRECTION_SAVE_SUCCESS.getMessage());
    }

}
