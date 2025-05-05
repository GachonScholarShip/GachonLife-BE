package com.gachonproject.movementservice.domain.direction.dto.request;

public record DirectionUpdateDto(
        Long id,
        String endPoint,
        String url
) {
}
