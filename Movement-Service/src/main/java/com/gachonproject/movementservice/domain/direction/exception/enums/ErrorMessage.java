package com.gachonproject.movementservice.domain.direction.exception.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorMessage {

    DIRECTION_NOT_FOUND("해당 목적지 길찾기 정보를 찾을 수 없습니다."),
    DUPLICATED_ENDPOINT_DIRECTION("해당 목적지 길찾기는 이미 존재합니다.");

    private final String message;

}
