package com.gachonproject.movementservice.domain.mudang.exception;

import com.gachonproject.movementservice.global.common.exception.BaseException;
import org.springframework.http.HttpStatus;

import static com.gachonproject.movementservice.domain.mudang.exception.enums.ErrorMessage.MUDANG_NOT_FOUND_EXCEPTION;

public class MudangNotFoundException extends BaseException {
    public MudangNotFoundException() {
        super(HttpStatus.BAD_REQUEST, MUDANG_NOT_FOUND_EXCEPTION.getMessage());
    }
}
