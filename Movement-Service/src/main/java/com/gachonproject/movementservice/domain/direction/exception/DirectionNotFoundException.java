package com.gachonproject.movementservice.domain.direction.exception;

import com.gachonproject.movementservice.global.common.exception.BaseException;
import org.springframework.http.HttpStatus;

import static com.gachonproject.movementservice.domain.direction.exception.enums.ErrorMessage.DIRECTION_NOT_FOUND;

public class DirectionNotFoundException extends BaseException {
    public DirectionNotFoundException() {
        super(HttpStatus.BAD_REQUEST, DIRECTION_NOT_FOUND.getMessage());
    }
}
