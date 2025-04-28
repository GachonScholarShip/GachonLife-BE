package com.gachonproject.movementservice.domain.roadview.controller;


import com.gachonproject.movementservice.domain.roadview.dto.request.RoadViewSaveDto;
import com.gachonproject.movementservice.domain.roadview.dto.request.RoadViewUpdateDto;
import com.gachonproject.movementservice.domain.roadview.dto.response.RoadViewDetailDto;
import com.gachonproject.movementservice.domain.roadview.entity.RoadView;
import com.gachonproject.movementservice.domain.roadview.repository.RoadViewRepository;
import com.gachonproject.movementservice.domain.roadview.usecase.RoadViewUseCase;
import com.gachonproject.movementservice.global.common.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.gachonproject.movementservice.domain.roadview.controller.enums.SuccessMessage.*;

@RestController
@RequiredArgsConstructor
public class RoadViewController {

    private final RoadViewUseCase roadViewUseCase;

    @PostMapping("/admin/road_view")
    public ApiResponse<Void> createRoadView(@RequestBody RoadViewSaveDto dto) {

        roadViewUseCase.saveRoadView(dto);

        return ApiResponse.response(HttpStatus.OK, ROAD_VIEW_CREATE_SUCCESS.getMessage());
    }

    @GetMapping("/member/road_view/{endPoint}")
    public ApiResponse<RoadViewDetailDto> getRoadView(@PathVariable(name = "endPoint") String endPoint) {

        RoadViewDetailDto response = roadViewUseCase.getRoadViewDetail(endPoint);

        return ApiResponse.response(HttpStatus.OK, ROAD_VIEW_DETAIL_SUCCESS.getMessage(), response);
    }

    @GetMapping("/member/road_view")
    public ApiResponse<List<RoadViewDetailDto>> getRoadViews(
            @RequestParam(defaultValue = "0", required = false) int pageNum,
            @RequestParam(defaultValue = "10", required = false) int pageSize
    ) {

        List<RoadViewDetailDto> response = roadViewUseCase.getRoadViewList(pageNum, pageSize);

        return ApiResponse.response(HttpStatus.OK, ROAD_VIEW_LIST_SUCCESS.getMessage(), response);
    }

    @PatchMapping("/admin/road_view")
    public ApiResponse<Void> updateRoadView(@RequestBody RoadViewUpdateDto dto) {

        roadViewUseCase.updateRoadView(dto);

        return ApiResponse.response(HttpStatus.OK, ROAD_VIEW_UPDATE_SUCCESS.getMessage());
    }

    @DeleteMapping("/admin/road_view/{roadViewId}")
    public ApiResponse<Void> deleteRoadView(@PathVariable(name = "roadViewId") Long roadViewId) {

        roadViewUseCase.deleteRoadView(roadViewId);

        return ApiResponse.response(HttpStatus.OK, ROAD_VIEW_DELETE_SUCCESS.getMessage());
    }

}
