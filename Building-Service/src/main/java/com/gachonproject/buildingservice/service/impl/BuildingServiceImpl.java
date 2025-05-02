package com.gachonproject.buildingservice.service.impl;

import com.gachonproject.buildingservice.domain.Building;
import com.gachonproject.buildingservice.dto.BuildingDto;
import com.gachonproject.buildingservice.dto.BuildingRequest;
import com.gachonproject.buildingservice.repository.BuildingRepository;
import com.gachonproject.buildingservice.service.BuildingService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BuildingServiceImpl implements BuildingService {

    private final BuildingRepository repo;

    @Override
    public List<BuildingDto> getAll() {
        return repo.findAll().stream()
                .map(this::toDto)
                .toList();
    }

    @Override
    public BuildingDto getByName(String buildingName) {
        Building b = repo.findByBuildingName(buildingName)
                .orElseThrow(() -> new EntityNotFoundException("건물을 찾을 수 없습니다: " + buildingName));
        return toDto(b);
    }

    @Override
    public BuildingDto create(BuildingRequest req) {
        if (repo.existsByBuildingName(req.getBuildingName())) {
            throw new IllegalArgumentException("이미 존재하는 건물이름입니다: " + req.getBuildingName());
        }
        Building b = new Building();
        b.setBuildingName(req.getBuildingName());
        b.setTopFloor(req.getTopFloor());
        b.setBottomFloor(req.getBottomFloor());
        b.setIsPublic(req.getIsPublic());
        Building saved = repo.save(b);
        return toDto(saved);
    }

    @Override
    public BuildingDto update(Long id, BuildingRequest req) {
        Building b = repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("해당 ID의 건물이 없습니다: " + id));
        b.setBuildingName(req.getBuildingName());
        b.setTopFloor(req.getTopFloor());
        b.setBottomFloor(req.getBottomFloor());
        b.setIsPublic(req.getIsPublic());
        b.setUpdatedAt(LocalDateTime.now());
        Building updated = repo.save(b);
        return toDto(updated);
    }

    @Override
    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new EntityNotFoundException("해당 ID의 건물이 없습니다: " + id);
        }
        repo.deleteById(id);
    }

    private BuildingDto toDto(Building b) {
        return new BuildingDto(
                b.getId(),
                b.getBuildingName(),
                b.getFloors(),
                b.getIsPublic()
        );
    }
}
