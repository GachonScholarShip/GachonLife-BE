package com.gachonproject.movementservice.domain.mudang.exception;

import com.gachonproject.movementservice.global.common.exception.BaseException;
import org.springframework.http.HttpStatus;

import static com.gachonproject.movementservice.domain.mudang.exception.enums.ErrorMessage.TOO_LATE_EXCEPTION;

public class MudangTooLateException extends BaseException {
    public MudangTooLateException() {
        super(HttpStatus.BAD_REQUEST, TOO_LATE_EXCEPTION.getMessage());
    }
}
