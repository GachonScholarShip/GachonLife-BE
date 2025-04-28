package com.gachonproject.movementservice.domain.roadview.dto.request;

public record RoadViewUpdateDto(
        Long roadViewId,
        String endPoint,
        String url
) {
}
