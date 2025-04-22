package com.gachonproject.userservice.domain.user.exception.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorMessage {

    // Auth
    STUDENT_ID_ALREADY_EXISTS("이미 존재하는 학번입니다."),
    LOGIN_ID_ALREADY_EXISTS("이미 존재하는 ID 입니다.");


    private final String message;
}
