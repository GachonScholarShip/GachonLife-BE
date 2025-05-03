package com.gachonproject.movementservice.domain.qrcode.controller;

import com.gachonproject.movementservice.domain.qrcode.dto.QrCodeDto;
import com.gachonproject.movementservice.domain.qrcode.usecase.QrCodeUseCase;
import com.gachonproject.movementservice.global.common.response.ApiResponse;
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
    public ApiResponse<Void> createQrCode(@RequestBody QrCodeDto dto) {

        qrCodeUseCase.createQrCode(dto);

        return ApiResponse.response(HttpStatus.OK, QRCODE_CREATE_SUCCESS.getMessage());
    }

    @GetMapping("/member/qrcode/{buildingName}")
    public ApiResponse<QrCodeDto> getQrCode(@PathVariable String buildingName) {

        QrCodeDto response = qrCodeUseCase.getQrCode(buildingName);

        return ApiResponse.response(HttpStatus.OK, QRCODE_GET_SUCCESS.getMessage(), response);
    }

    @PatchMapping("/admin/qrcode")
    public ApiResponse<Void> updateQrCode(@RequestBody QrCodeDto dto) {



    }
}
