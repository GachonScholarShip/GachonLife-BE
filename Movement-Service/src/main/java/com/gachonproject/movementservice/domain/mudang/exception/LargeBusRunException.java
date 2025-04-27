package com.gachonproject.movementservice.domain.mudang.exception;

import com.gachonproject.movementservice.global.common.exception.BaseException;
import org.springframework.http.HttpStatus;

import static com.gachonproject.movementservice.domain.mudang.exception.enums.ErrorMessage.LARGE_BUS_RUN_EXCEPTION;

public class LargeBusRunException extends BaseException {
    public LargeBusRunException() {
        super(HttpStatus.BAD_REQUEST, LARGE_BUS_RUN_EXCEPTION.getMessage());
    }
}
