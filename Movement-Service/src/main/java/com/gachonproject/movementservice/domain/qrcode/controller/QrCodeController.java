package com.gachonproject.movementservice.domain.qrcode.controller;

import com.gachonproject.movementservice.domain.qrcode.dto.request.QrCodeSaveDto;
import com.gachonproject.movementservice.domain.qrcode.dto.response.QrCodeDetailDto;
import com.gachonproject.movementservice.domain.qrcode.entity.QrCode;
import com.gachonproject.movementservice.domain.qrcode.usecase.QrCodeUseCase;
import com.gachonproject.movementservice.global.common.response.ApiResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static com.gachonproject.movementservice.domain.qrcode.controller.enums.SuccessMessage.QRCODE_CREATE_SUCCESS;
import static com.gachonproject.movementservice.domain.qrcode.controller.enums.SuccessMessage.QRCODE_GET_SUCCESS;

@RestController
@RequiredArgsConstructor
public class QrCodeController {

    private final QrCodeUseCase qrCodeUseCase;

    @PostMapping("/admin/qrcode")
    public ApiResponse<Void> createQrCode(@RequestBody QrCodeSaveDto dto) {

        qrCodeUseCase.createQrCode(dto);

        return ApiResponse.response(HttpStatus.OK, QRCODE_CREATE_SUCCESS.getMessage());
    }

    @GetMapping("/member/qrcode/{buildingName}")
    public ApiResponse<QrCodeDetailDto> getQrCode(@PathVariable String buildingName) {

        QrCodeDetailDto response = qrCodeUseCase.getQrCode(buildingName);

        return ApiResponse.response(HttpStatus.OK, QRCODE_GET_SUCCESS.getMessage(), response);
    }
}
