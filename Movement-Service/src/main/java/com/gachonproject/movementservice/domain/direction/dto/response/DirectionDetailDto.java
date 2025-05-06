package com.gachonproject.movementservice.domain.direction.dto.response;

import com.gachonproject.movementservice.domain.direction.entity.Direction;
import lombok.Builder;

@Builder
public record DirectionDetailDto(
        Long id,
        String endPoint,
        String url
) {
    public static DirectionDetailDto from(Direction direction) {
        return DirectionDetailDto.builder()
                .id(direction.getId())
                .endPoint(direction.getEndPoint())
                .url(direction.getUrl())
                .build();
    }
}
