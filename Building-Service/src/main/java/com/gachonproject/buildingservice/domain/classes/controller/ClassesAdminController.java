package com.gachonproject.buildingservice.domain.classes.controller;

import com.gachonproject.buildingservice.domain.classes.dto.*;
import com.gachonproject.buildingservice.domain.classes.service.ClassesService;
import com.gachonproject.buildingservice.global.common.response.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/admin/classes")
@RequiredArgsConstructor
public class ClassesAdminController {
    private final ClassesService service;

    @GetMapping
    public ApiResponse<List<ClassesDto>> listAll() {
        return ApiResponse.response(HttpStatus.OK, "관리자용 전체 목록 조회", service.getAll());
    }

    @GetMapping("/{id}")
    public ApiResponse<ClassesDto> detail(@PathVariable Long id) {
        return ApiResponse.response(HttpStatus.OK, "관리자용 상세 조회", service.getById(id));
    }

    @PostMapping
    public ApiResponse<ClassesDto> create(@Valid @RequestBody ClassesRequest req) {
        return ApiResponse.response(HttpStatus.CREATED, "강의실 생성 성공", service.create(req));
    }

    @PutMapping("/{id}")
    public ApiResponse<ClassesDto> update(
            @PathVariable Long id,
            @Valid @RequestBody ClassesRequest req
    ) {
        return ApiResponse.response(HttpStatus.OK, "강의실 수정 성공", service.update(id, req));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ApiResponse.response(HttpStatus.NO_CONTENT, "강의실 삭제 성공");
    }
}
