package com.gachonproject.movementservice.domain.roadview.controller.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SuccessMessage {

    ROAD_VIEW_DETAIL_SUCCESS("로드뷰 정보를 조회했습니다."),
    ROAD_VIEW_CREATE_SUCCESS("로드뷰 정보를 생성했습니다.");

    private final String message;

}
