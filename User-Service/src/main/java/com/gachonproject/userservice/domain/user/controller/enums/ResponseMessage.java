package com.gachonproject.userservice.domain.user.controller.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseMessage {

    // AuthController
    REGISTER_SUCCESS("회원가입에 성공했습니다.");

    private final String message;
}
