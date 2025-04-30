package com.gachonproject.buildingservice.service;

import com.gachonproject.buildingservice.dto.BuildingDto;
import com.gachonproject.buildingservice.dto.BuildingRequest;
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
