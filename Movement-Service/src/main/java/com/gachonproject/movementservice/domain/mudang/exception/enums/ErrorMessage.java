package com.gachonproject.movementservice.domain.mudang.exception.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorMessage {

    MUDANG_NOT_FOUND_EXCEPTION("해당 무당이 시간표를 찾을 수 없습니다."),
    DUPLICATED_MUDANG_EXCEPTION("중복되는 무당이 시간표입니다."),
    LARGE_BUS_RUN_EXCEPTION("현재 대형버스 운행중입니다."),
    TOO_LATE_EXCEPTION("너무 늦은 시간이라 무당이가 운행하지 않습니다");


    private final String message;
}
