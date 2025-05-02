package com.gachonproject.buildingservice.domain.building.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.List;

@Getter
@AllArgsConstructor
public class BuildingDto {
    private Long id;
    private String buildingName;
    private List<String> floors;
    private Boolean isPublic;
}
