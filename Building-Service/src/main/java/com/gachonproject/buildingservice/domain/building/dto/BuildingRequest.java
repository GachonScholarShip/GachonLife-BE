package com.gachonproject.buildingservice.domain.building.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BuildingRequest {

    private String buildingName;

    private Integer topFloor;

    private Integer bottomFloor;

    private Boolean isPublic;
}
