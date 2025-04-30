package com.gachonproject.movementservice.domain.roadview.entity;

import com.gachonproject.movementservice.domain.roadview.dto.request.RoadViewSaveDto;
import com.gachonproject.movementservice.domain.roadview.dto.request.RoadViewUpdateDto;
import com.gachonproject.movementservice.global.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Table(name = "road_view")
@SuperBuilder
@NoArgsConstructor(access= AccessLevel.PROTECTED)
public class RoadView extends BaseEntity {

    @Column(nullable = false, length = 50)
    String endPoint;

    @Column(nullable = false, length = 512)
    String url;

    public static RoadView from(RoadViewSaveDto dto) {
        return RoadView.builder()
                .endPoint(dto.endPoint())
                .url(dto.url())
                .build();
    }

    public void updateRoadView(RoadViewUpdateDto dto) {
        this.endPoint = dto.endPoint();
        this.url = dto.url();
    }

}
