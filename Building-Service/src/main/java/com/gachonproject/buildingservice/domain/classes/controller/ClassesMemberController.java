package com.gachonproject.buildingservice.domain.classes.controller;

import com.gachonproject.buildingservice.domain.classes.dto.ClassesDto;
import com.gachonproject.buildingservice.domain.classes.service.ClassesService;
import com.gachonproject.buildingservice.global.common.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// 변경된 RequestMapping 경로
@RequestMapping("/member/classes")
@RequiredArgsConstructor
public class ClassesMemberController {

    private final ClassesService service;


    @GetMapping
    public ApiResponse<List<ClassesDto>> list() {
        return ApiResponse.response(HttpStatus.OK,
                "강의실 목록 조회 성공",
                service.getAll());
    }


    @GetMapping("/{id}")
    public ApiResponse<ClassesDto> detail(@PathVariable Long id) {
        return ApiResponse.response(HttpStatus.OK,
                "강의실 상세 조회 성공",
                service.getById(id));
    }
}
