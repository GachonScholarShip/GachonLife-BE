package com.gachonproject.userservice.domain.user.exception;

import com.gachonproject.userservice.global.common.exception.BaseException;
import org.springframework.http.HttpStatus;

import static com.gachonproject.userservice.domain.user.exception.enums.ErrorMessage.LOGIN_ID_ALREADY_EXISTS;

public class LoginIdExistsException extends BaseException {
    public LoginIdExistsException() {
        super(HttpStatus.BAD_REQUEST, LOGIN_ID_ALREADY_EXISTS.getMessage());
    }

}
