package com.gachonproject.movementservice.domain.roadview.dto.response;

import com.gachonproject.movementservice.domain.roadview.entity.RoadView;
import lombok.Builder;

@Builder
public record RoadViewDetailDto(
        Long roadViewId,
        String endPoint,
        String url
) {
    public static RoadViewDetailDto from(RoadView roadView) {
        return RoadViewDetailDto.builder()
                .roadViewId(roadView.getId())
                .endPoint(roadView.getEndPoint())
                .url(roadView.getUrl())
                .build();
    }
}
