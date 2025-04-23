package com.gachonproject.userservice.domain.user.controller.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseMessage {

    // UserController
    USER_LIST_SUCCESS("사용자 목록을 반환합니다. "),
    USER_UPDATE_SUCCESS("사용자 정보를 수정했습니다."),
    USER_DELETE_SUCCESS("사용자를 삭제(회원탈퇴)했습니다."),

    // AuthController
    REGISTER_SUCCESS("회원가입에 성공했습니다.");

    private final String message;
}
