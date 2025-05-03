package com.gachonproject.movementservice.domain.qrcode.controller.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SuccessMessage {

    QRCODE_GET_SUCCESS("QR코드 정보를 조회했습니다."),
    QRCODE_CREATE_SUCCESS("QR코드 정보를 성공적으로 생성했습니다."),;

    private final String message;

}
