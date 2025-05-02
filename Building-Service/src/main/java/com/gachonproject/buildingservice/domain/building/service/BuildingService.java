package com.gachonproject.buildingservice.domain.building.service;

import com.gachonproject.buildingservice.domain.building.dto.BuildingDto;
import com.gachonproject.buildingservice.domain.building.dto.BuildingRequest;
import java.util.List;

public interface    BuildingService {
    // Member
    List<BuildingDto> getAll();
    BuildingDto getByName(String buildingName);

    // Manager
    BuildingDto create(BuildingRequest req);
    BuildingDto update(Long id, BuildingRequest req);
    void delete(Long id);
}
