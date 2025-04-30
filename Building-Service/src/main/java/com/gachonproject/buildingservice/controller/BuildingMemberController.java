package com.gachonproject.buildingservice.controller;

import com.gachonproject.buildingservice.dto.BuildingDto;
import com.gachonproject.buildingservice.global.common.response.ApiResponse;
import com.gachonproject.buildingservice.service.BuildingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/member/building")
@RequiredArgsConstructor
public class BuildingMemberController {

    private final BuildingService service;

    /**
     * 전체 건물명 목록 조회 (사용자 전용)
     * -> BuildingDto 전체가 아니라, 건물 이름(String)만 꺼내서 리턴
     */
    @GetMapping
    public ApiResponse<List<String>> listNamesOnly() {
        List<String> names = service.getAll().stream()
                .map(BuildingDto::getBuildingName)
                .collect(Collectors.toList());

        return ApiResponse.response(
                HttpStatus.OK,
                "건물명 목록 조회 성공",
                names
        );
    }

    /**
     * 특정 건물 상세 조회 (사용자 전용)
     * -> 지금처럼 floors 등 전체 BuildingDto 그대로
     */
    @GetMapping("/{buildingName}")
    public ApiResponse<BuildingDto> getOne(@PathVariable String buildingName) {
        BuildingDto dto = service.getByName(buildingName);
        return ApiResponse.response(
                HttpStatus.OK,
                buildingName + " 건물 상세 조회 성공",
                dto
        );
    }
}
