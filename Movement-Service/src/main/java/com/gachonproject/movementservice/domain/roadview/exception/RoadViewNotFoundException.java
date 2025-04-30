package com.gachonproject.movementservice.domain.roadview.exception;

import com.gachonproject.movementservice.global.common.exception.BaseException;
import org.springframework.http.HttpStatus;

import static com.gachonproject.movementservice.domain.roadview.exception.enums.ErrorMessage.ROAD_VIEW_NOT_FOUND;

public class RoadViewNotFoundException extends BaseException {
    public RoadViewNotFoundException() {
        super(HttpStatus.BAD_REQUEST, ROAD_VIEW_NOT_FOUND.getMessage());
    }
}
