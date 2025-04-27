package com.gachonproject.movementservice.domain.mudang.dto.response;

import com.gachonproject.movementservice.domain.mudang.entity.Mudang;
import lombok.Builder;

@Builder
public record MudangDetailDto(
        Long mudangId,
        String timeslot
) {
    public static MudangDetailDto from(Mudang mudang) {
        return MudangDetailDto.builder()
                .mudangId(mudang.getId())
                .timeslot(mudang.getTimeslot())
                .build();
    }
}
