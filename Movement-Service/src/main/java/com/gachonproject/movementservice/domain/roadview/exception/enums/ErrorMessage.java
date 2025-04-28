package com.gachonproject.movementservice.domain.roadview.exception.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorMessage {

    DUPLICATED_ROAD_VIEW("중복되는 로드뷰 도착지입니다."),
    ROAD_VIEW_NOT_FOUND("해당 로드뷰를 찾을 수 없습니다.");

    private final String message;
}
