package com.gachonproject.movementservice.domain.mudang.entity;

import com.gachonproject.movementservice.domain.mudang.dto.request.MudangSaveDto;
import com.gachonproject.movementservice.global.common.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@Entity
@SuperBuilder
@Table(name = "Mudang")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Mudang extends BaseEntity {

    private String timeslot;

    public static Mudang from(MudangSaveDto dto) {
        return Mudang.builder()
                .timeslot(dto.timeslot())
                .build();
    }

}
