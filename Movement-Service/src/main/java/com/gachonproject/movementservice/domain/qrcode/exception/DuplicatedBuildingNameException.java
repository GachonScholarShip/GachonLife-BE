package com.gachonproject.movementservice.domain.qrcode.exception;

import com.gachonproject.movementservice.global.common.exception.BaseException;
import org.springframework.http.HttpStatus;

import static com.gachonproject.movementservice.domain.qrcode.exception.ErrorMessage.DUPLICATED_BUILDING_NAME;

public class DuplicatedBuildingNameException extends BaseException {
    public DuplicatedBuildingNameException() {
        super(HttpStatus.BAD_REQUEST, DUPLICATED_BUILDING_NAME.getMessage());
    }
}
