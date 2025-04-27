package com.gachonproject.movementservice.domain.mudang.exception;

import com.gachonproject.movementservice.global.common.exception.BaseException;
import org.springframework.http.HttpStatus;

import static com.gachonproject.movementservice.domain.mudang.exception.enums.ErrorMessage.DUPLICATED_MUDANG_EXCEPTION;

public class DuplicatedMudangException extends BaseException {
    public DuplicatedMudangException() {
        super(HttpStatus.BAD_REQUEST, DUPLICATED_MUDANG_EXCEPTION.getMessage());
    }
}
