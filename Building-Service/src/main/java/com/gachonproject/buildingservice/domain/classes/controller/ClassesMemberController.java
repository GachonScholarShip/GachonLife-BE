package com.gachonproject.buildingservice.domain.classes.controller;

import com.gachonproject.buildingservice.domain.classes.dto.ClassesDto;
import com.gachonproject.buildingservice.domain.classes.service.ClassesService;
import com.gachonproject.buildingservice.global.common.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member/classes")
@RequiredArgsConstructor
public class ClassesMemberController {

    private final ClassesService service;

    /** 페이지네이션된 목록 조회 (기본 페이지 크기: 10 000) */
    @GetMapping
    public ApiResponse<Page<ClassesDto>> list(
            @PageableDefault(size = 10000) Pageable pageable
    ) {
        Page<ClassesDto> page = service.getAll(pageable);
        return ApiResponse.response(HttpStatus.OK, "강의실 목록 조회 성공", page);
    }

    /** 상세 조회 */
    @GetMapping("/{id}")
    public ApiResponse<ClassesDto> detail(@PathVariable Long id) {
        ClassesDto dto = service.getById(id);
        return ApiResponse.response(HttpStatus.OK, "강의실 상세 조회 성공", dto);
    }
}
