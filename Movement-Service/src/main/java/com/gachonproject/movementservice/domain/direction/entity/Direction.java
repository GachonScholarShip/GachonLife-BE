package com.gachonproject.movementservice.domain.direction.entity;

import com.gachonproject.movementservice.domain.direction.dto.request.DirectionSaveDto;
import com.gachonproject.movementservice.domain.direction.dto.request.DirectionUpdateDto;
import com.gachonproject.movementservice.global.common.entity.BaseEntity;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@Entity
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Direction extends BaseEntity {

    private String endPoint;

    private String url;

    public static Direction from(DirectionSaveDto dto) {
        return Direction.builder()
                .endPoint(dto.endPoint())
                .url(dto.url())
                .build();
    }

    public void update(DirectionUpdateDto dto) {
        this.endPoint = dto.endPoint();
        this.url = dto.url();
    }

}
