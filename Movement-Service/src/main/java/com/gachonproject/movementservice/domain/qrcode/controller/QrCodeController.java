package com.gachonproject.movementservice.domain.qrcode.controller;

import com.gachonproject.movementservice.domain.qrcode.dto.request.QrCodeSaveDto;
import com.gachonproject.movementservice.domain.qrcode.entity.QrCode;
import com.gachonproject.movementservice.domain.qrcode.usecase.QrCodeUseCase;
import com.gachonproject.movementservice.global.common.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.gachonproject.movementservice.domain.qrcode.controller.enums.SuccessMessage.QRCODE_CREATE_SUCCESS;

@RestController
@RequiredArgsConstructor
public class QrCodeController {

    private final QrCodeUseCase qrCodeUseCase;

    @PostMapping("/admin/qrcode")
    public ApiResponse<Void> createQrCode(@RequestBody QrCodeSaveDto dto) {

        qrCodeUseCase.createQrCode(dto);

        return ApiResponse.response(HttpStatus.OK, QRCODE_CREATE_SUCCESS.getMessage());
    }
}
