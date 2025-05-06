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

    @GetMapping("/member/direction/{endPoint}")
    public ApiResponse<DirectionDetailDto> getDirection(@PathVariable("endPoint") String endPoint) {

        DirectionDetailDto response = directionUseCase.getDirectionDetail(endPoint);

        return ApiResponse.response(HttpStatus.OK, DIRECTION_DETAIL_GET_SUCCESS.getMessage(), response);
    }

    @GetMapping("/admin/direction")
    public ApiResponse<List<DirectionDetailDto>> getDirectionsList(
            @RequestParam(defaultValue = "0", required = false) int pageNum,
            @RequestParam(defaultValue = "10", required = false) int pageSize
    ) {

        List<DirectionDetailDto> response = directionUseCase.getDirectionList(pageNum, pageSize);

        return ApiResponse.response(HttpStatus.OK, DIRECTION_LIST_GET_SUCCESS.getMessage(), response);
    }

    @PatchMapping("/admin/direction")
    public ApiResponse<Void> updateDirection(@RequestBody DirectionUpdateDto dto) {

        directionUseCase.updateDirection(dto);

        return ApiResponse.response(HttpStatus.OK, DIRECTION_UPDATE_SUCCESS.getMessage());
    }

    @DeleteMapping("/admin/direction/{directionId}")
    public ApiResponse<Void> deleteDirection(@PathVariable("directionId") Long directionId) {

        directionUseCase.deleteDirection(directionId);

        return ApiResponse.response(HttpStatus.OK, DIRECTION_DELETE_SUCCESS.getMessage());
    }

}
