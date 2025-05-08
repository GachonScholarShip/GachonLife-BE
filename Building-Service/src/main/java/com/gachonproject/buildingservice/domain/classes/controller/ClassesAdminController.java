package com.gachonproject.buildingservice.domain.classes.controller;

import com.gachonproject.buildingservice.domain.classes.dto.ClassesDto;
import com.gachonproject.buildingservice.domain.classes.dto.ClassesRequest;
import com.gachonproject.buildingservice.domain.classes.service.ClassesService;
import com.gachonproject.buildingservice.global.common.response.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/classes")
@RequiredArgsConstructor
public class ClassesAdminController {


    private final ClassesService service;

    @GetMapping
    public ApiResponse<Page<ClassesDto>> listAll(
            @PageableDefault(size = 10000) Pageable pageable
    ) {
        Page<ClassesDto> page = service.getAll(pageable);
        return ApiResponse.response(HttpStatus.OK, "관리자용 전체 목록 조회", page);
    }

    @GetMapping("/detail")
    public ApiResponse<List<ClassesDto>> getById(
            @RequestParam String buildingName,
            @RequestParam String floor,
            @RequestParam int pageNum,
            @RequestParam int pageSize
    ) {

        List<ClassesDto> response = service.getDetailList(buildingName, floor, pageNum, pageSize);

        return ApiResponse.response(HttpStatus.OK, "건물에 따른 강의실 목록을 반환합니다.", response);
    }

    /** 상세 조회 (GET /admin/classes/{id}) */
    @GetMapping("/{id}")
    public ApiResponse<ClassesDto> detail(@PathVariable Long id) {
        ClassesDto dto = service.getById(id);
        return ApiResponse.response(HttpStatus.OK, "관리자용 상세 조회", dto);
    }

    /** 생성 (POST /admin/classes) */
    @PostMapping
    public ApiResponse<ClassesDto> create(@Valid @RequestBody ClassesRequest req) {
        ClassesDto dto = service.create(req);
        return ApiResponse.response(HttpStatus.CREATED, "강의실 생성 성공", dto);
    }

    /** 전체 수정 (PUT /admin/classes/{id}) */
    @PutMapping("/{id}")
    public ApiResponse<ClassesDto> update(
            @PathVariable Long id,
            @Valid @RequestBody ClassesRequest req
    ) {
        ClassesDto dto = service.update(id, req);
        return ApiResponse.response(HttpStatus.OK, "강의실 수정 성공", dto);
    }

    /** 부분 수정도 허용 (PATCH /admin/classes/{id}) */
    @PatchMapping("/{id}")
    public ApiResponse<ClassesDto> partialUpdate(
            @PathVariable Long id,
            @Valid @RequestBody ClassesRequest req
    ) {

        ClassesDto dto = service.update(id, req);
        return ApiResponse.response(HttpStatus.OK, "강의실 부분 수정 성공", dto);
    }

    /** 삭제 (DELETE /admin/classes/{id}) */
    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ApiResponse.response(HttpStatus.NO_CONTENT, "강의실 삭제 성공");
    }
}
