package com.gachonproject.userservice.domain.user.exception;

import com.gachonproject.userservice.global.common.exception.BaseException;
import org.springframework.http.HttpStatus;

import static com.gachonproject.userservice.domain.user.exception.enums.ErrorMessage.USER_NOT_FOUND;

public class UserNotFoundException extends BaseException {
  public UserNotFoundException() {
    super(HttpStatus.BAD_REQUEST, USER_NOT_FOUND.getMessage());
  }
}
