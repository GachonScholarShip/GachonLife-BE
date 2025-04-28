package com.gachonproject.movementservice.domain.roadview.controller;


import com.gachonproject.movementservice.domain.roadview.dto.request.RoadViewSaveDto;
import com.gachonproject.movementservice.domain.roadview.entity.RoadView;
import com.gachonproject.movementservice.domain.roadview.repository.RoadViewRepository;
import com.gachonproject.movementservice.domain.roadview.usecase.RoadViewUseCase;
import com.gachonproject.movementservice.global.common.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.gachonproject.movementservice.domain.roadview.controller.enums.SuccessMessage.ROAD_VIEW_CREATE_SUCCESS;

@RestController
@RequiredArgsConstructor
public class RoadViewController {

    private final RoadViewUseCase roadViewUseCase;

    @PostMapping("/admin/road_view")
    public ApiResponse<Void> createRoadView(@RequestBody RoadViewSaveDto dto) {

        roadViewUseCase.saveRoadView(dto);

        return ApiResponse.response(HttpStatus.OK, ROAD_VIEW_CREATE_SUCCESS.getMessage());
    }

}
