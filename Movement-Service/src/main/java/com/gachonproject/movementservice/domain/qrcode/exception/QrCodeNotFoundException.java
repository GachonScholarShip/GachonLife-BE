package com.gachonproject.movementservice.domain.qrcode.exception;

import com.gachonproject.movementservice.global.common.exception.BaseException;
import org.springframework.http.HttpStatus;

import static com.gachonproject.movementservice.domain.qrcode.exception.ErrorMessage.QRCODE_NOT_FOUND;

public class QrCodeNotFoundException extends BaseException {
    public QrCodeNotFoundException() {
        super(HttpStatus.BAD_REQUEST, QRCODE_NOT_FOUND.getMessage());
    }
}
