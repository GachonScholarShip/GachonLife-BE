package com.gachonproject.movementservice.domain.qrcode.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorMessage {

    QRCODE_NOT_FOUND("존재하지 않는 QR코드입니다."),
    DUPLICATED_BUILDING_NAME("해당 건물 QR코드는 이미 존재합니다.");

    private final String message;
}

