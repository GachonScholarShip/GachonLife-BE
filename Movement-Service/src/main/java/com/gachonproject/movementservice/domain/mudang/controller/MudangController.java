package com.gachonproject.movementservice.domain.mudang.controller;

import com.gachonproject.movementservice.domain.mudang.dto.request.MudangSaveDto;
import com.gachonproject.movementservice.domain.mudang.dto.request.MudangUpdateDto;
import com.gachonproject.movementservice.domain.mudang.service.MudangSaveService;
import com.gachonproject.movementservice.domain.mudang.usecase.MudangUseCase;
import com.gachonproject.movementservice.global.common.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static com.gachonproject.movementservice.domain.mudang.controller.enums.SuccessMessage.*;

@RestController
@RequiredArgsConstructor
public class MudangController {

    private final MudangUseCase mudangUseCase;


    @PostMapping("/admin/mudang")
    public ApiResponse<Void> saveMudangTime(@RequestBody MudangSaveDto dto) {

        mudangUseCase.createMudang(dto);

        return ApiResponse.response(HttpStatus.OK, MUDANG_CREATE.getMessage());
    }



}
