package com.gachonproject.movementservice.domain.direction.exception;

import com.gachonproject.movementservice.global.common.exception.BaseException;
import org.springframework.http.HttpStatus;

import static com.gachonproject.movementservice.domain.direction.exception.enums.ErrorMessage.DUPLICATED_ENDPOINT_DIRECTION;

public class DuplicatedDirectionEndPointException extends BaseException {
    public DuplicatedDirectionEndPointException() {
        super(HttpStatus.BAD_REQUEST, DUPLICATED_ENDPOINT_DIRECTION.getMessage());
    }
}
