package com.gachonproject.movementservice.domain.roadview.exception;

import com.gachonproject.movementservice.global.common.exception.BaseException;
import org.springframework.http.HttpStatus;

import static com.gachonproject.movementservice.domain.roadview.exception.enums.ErrorMessage.DUPLICATED_ROAD_VIEW;

public class DuplicatedRoadViewException extends BaseException {
    public DuplicatedRoadViewException() {
        super(HttpStatus.BAD_REQUEST, DUPLICATED_ROAD_VIEW.getMessage());
    }
}
