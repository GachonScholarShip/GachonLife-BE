package com.gachonproject.movementservice.domain.qrcode.controller;

import com.gachonproject.movementservice.domain.qrcode.dto.QrCodeDetailDto;
import com.gachonproject.movementservice.domain.qrcode.dto.QrCodeDto;
import com.gachonproject.movementservice.domain.qrcode.usecase.QrCodeUseCase;
import com.gachonproject.movementservice.global.common.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static com.gachonproject.movementservice.domain.qrcode.controller.enums.SuccessMessage.*;

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
    public ApiResponse<QrCodeDetailDto> getQrCode(@PathVariable String buildingName) {

        QrCodeDetailDto response = qrCodeUseCase.getQrCode(buildingName);

        return ApiResponse.response(HttpStatus.OK, QRCODE_GET_SUCCESS.getMessage(), response);
    }

    @PatchMapping("/admin/qrcode")
    public ApiResponse<Void> updateQrCode(@RequestBody QrCodeDetailDto dto) {

        qrCodeUseCase.updateQrCode(dto);

        return ApiResponse.response(HttpStatus.OK, QRCODE_UPDATE_SUCCESS.getMessage());
    }

    @DeleteMapping("/admin/qrcode/{qrCodeId}")
    public ApiResponse<Void> deleteQrCode(@PathVariable Long qrCodeId) {

        qrCodeUseCase.deleteQrCode(qrCodeId);

        return ApiResponse.response(HttpStatus.OK, QRCODE_DELETE_SUCCESS.getMessage());
    }
}
