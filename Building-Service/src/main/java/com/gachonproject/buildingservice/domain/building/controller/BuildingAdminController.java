package com.gachonproject.buildingservice.domain.building.controller;

import com.gachonproject.buildingservice.domain.building.dto.BuildingDto;
import com.gachonproject.buildingservice.domain.building.dto.BuildingRequest;
import com.gachonproject.buildingservice.domain.building.service.BuildingService;
import com.gachonproject.buildingservice.global.common.response.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/building")
@RequiredArgsConstructor
public class BuildingAdminController {

    private final BuildingService service;

    @GetMapping
    public ApiResponse<List<BuildingDto>> listAll() {
        return ApiResponse.response(
                HttpStatus.OK,
                "관리자용 전체 건물 목록 조회 성공",
                service.getAll()
        );
    }

    @GetMapping("/{buildingName}")
    public ApiResponse<BuildingDto> detail(@PathVariable String buildingName) {
        return ApiResponse.response(
                HttpStatus.OK,
                "관리자용 건물 상세 조회 성공",
                service.getByName(buildingName)
        );
    }

    @PostMapping
    public ApiResponse<BuildingDto> create(@Valid @RequestBody BuildingRequest req) {
        return ApiResponse.response(
                HttpStatus.CREATED,
                "건물 생성 성공",
                service.create(req)
        );
    }

    @PutMapping("/{id}")
    public ApiResponse<BuildingDto> update(
            @PathVariable Long id,
            @Valid @RequestBody BuildingRequest req) {
        return ApiResponse.response(
                HttpStatus.OK,
                "건물 수정 성공",
                service.update(id, req)
        );
    }

    @PatchMapping("/{id}")
    public ApiResponse<BuildingDto> patchUpdate(
            @PathVariable Long id,
            @Valid @RequestBody BuildingRequest req
    ) {
        return ApiResponse.response(HttpStatus.OK,
                "건물 수정 성공",
                service.update(id, req));
    }


    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ApiResponse.response(
                HttpStatus.NO_CONTENT,
                "건물 삭제 성공"
        );
    }
}
