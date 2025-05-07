package com.gachonproject.buildingservice.domain.classes.controller;

import com.gachonproject.buildingservice.domain.classes.dto.ClassesDto;
import com.gachonproject.buildingservice.domain.classes.dto.ClassesRequest;
import com.gachonproject.buildingservice.domain.classes.service.ClassesService;
import com.gachonproject.buildingservice.global.common.response.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/classes")
@RequiredArgsConstructor
public class ClassesAdminController {

    private final ClassesService service;

    /** 페이지네이션된 전체 목록 조회 */
    @GetMapping
    public ApiResponse<Page<ClassesDto>> listAll(Pageable pageable) {
        Page<ClassesDto> page = service.getAll(pageable);
        return ApiResponse.response(HttpStatus.OK, "관리자용 전체 목록 조회", page);
    }

    /** 상세 조회 */
    @GetMapping("/{id}")
    public ApiResponse<ClassesDto> detail(@PathVariable Long id) {
        ClassesDto dto = service.getById(id);
        return ApiResponse.response(HttpStatus.OK, "관리자용 상세 조회", dto);
    }

    /** 생성 */
    @PostMapping
    public ApiResponse<ClassesDto> create(@Valid @RequestBody ClassesRequest req) {
        ClassesDto dto = service.create(req);
        return ApiResponse.response(HttpStatus.CREATED, "강의실 생성 성공", dto);
    }

    /** 수정 */
    @PutMapping("/{id}")
    public ApiResponse<ClassesDto> update(
            @PathVariable Long id,
            @Valid @RequestBody ClassesRequest req
    ) {
        ClassesDto dto = service.update(id, req);
        return ApiResponse.response(HttpStatus.OK, "강의실 수정 성공", dto);
    }

    /** 삭제 */
    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ApiResponse.response(HttpStatus.NO_CONTENT, "강의실 삭제 성공");
    }
}
