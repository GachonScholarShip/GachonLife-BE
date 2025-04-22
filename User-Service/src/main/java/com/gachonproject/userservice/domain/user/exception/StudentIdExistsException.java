package com.gachonproject.userservice.domain.user.exception;

import com.gachonproject.userservice.global.common.exception.BaseException;

import static com.gachonproject.userservice.domain.user.exception.enums.ErrorMessage.STUDENT_ID_ALREADY_EXISTS;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

public class StudentIdExistsException extends BaseException {
    public StudentIdExistsException() {
        super(BAD_REQUEST, STUDENT_ID_ALREADY_EXISTS.getMessage());
    }
}
