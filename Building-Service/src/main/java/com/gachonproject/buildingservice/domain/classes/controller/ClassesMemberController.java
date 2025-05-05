package com.gachonproject.buildingservice.domain.classes.controller;

import com.gachonproject.buildingservice.domain.classes.dto.ClassesDto;
import com.gachonproject.buildingservice.domain.classes.service.ClassesService;
import com.gachonproject.buildingservice.global.common.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/classes")      // ← 여길 바꿔주세요!
@RequiredArgsConstructor
public class ClassesMemberController {

    private final ClassesService service;

    /** 사용자용 전체 강의실 조회 */
    @GetMapping
    public ApiResponse<List<ClassesDto>> list() {
        List<ClassesDto> all = service.getAll();
        return ApiResponse.response(HttpStatus.OK, "강의실 목록 조회 성공", all);
    }

    /** 사용자용 단일 강의실 상세 조회 */
    @GetMapping("/{id}")
    public ApiResponse<ClassesDto> detail(@PathVariable Long id) {
        ClassesDto dto = service.getById(id);
        return ApiResponse.response(HttpStatus.OK, "강의실 상세 조회 성공", dto);
    }
}
