package com.gachonproject.movementservice.domain.mudang.controller.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SuccessMessage {

    MUDANG_DELETE("무당이 시간표를 삭제했습니다."),
    MUDANG_UPDATE("무당이 시간표를 변경했습니다."),
    MUDANG_SINGLE_TIME("무당이 시간표를 반환합니다."),
    MUDANG_CREATE("무당이 시간표를 성공적으로 생성했습니다.");

    private final String message;
}
