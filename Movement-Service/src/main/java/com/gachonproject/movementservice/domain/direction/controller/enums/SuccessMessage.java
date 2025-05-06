package com.gachonproject.movementservice.domain.direction.controller.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SuccessMessage {

    DIRECTION_DELETE_SUCCESS("길찾기 정보를 삭제합니다."),
    DIRECTION_UPDATE_SUCCESS("길찾기 정보를 수정합니다."),
    DIRECTION_LIST_GET_SUCCESS("길찾기 목록 정보를 반홥합니다."),
    DIRECTION_DETAIL_GET_SUCCESS("길찾기 단일 정보를 반환합니다."),
    DIRECTION_SAVE_SUCCESS("성공적으로 길찾기 정보를 저장했습니다.");

    private final String message;

}
