package com.gachonproject.buildingservice.service.impl;

import com.gachonproject.buildingservice.domain.Building;
import com.gachonproject.buildingservice.dto.BuildingDto;
import com.gachonproject.buildingservice.dto.BuildingRequest;
import com.gachonproject.buildingservice.repository.BuildingRepository;
import com.gachonproject.buildingservice.service.BuildingService;
import com.gachonproject.buildingservice.util.FloorFormatter;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
@Transactional
public class BuildingServiceImpl implements BuildingService {

    private final BuildingRepository repo;

    @Override
    @Transactional(readOnly = true)
    public List<BuildingDto> getAll() {
        return repo.findAll().stream()
                .map(this::toDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
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
    @Transactional
    public BuildingDto update(Long id, BuildingRequest req) {
        Building b = repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("해당 ID의 건물이 없습니다: " + id));

        b.setBuildingName(req.getBuildingName());
        b.setTopFloor(req.getTopFloor());
        b.setBottomFloor(req.getBottomFloor());
        b.setIsPublic(req.getIsPublic());
        b.setUpdatedAt(LocalDateTime.now());

        return toDto(b);
    }

    @Override
    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new EntityNotFoundException("해당 ID의 건물이 없습니다: " + id);
        }
        repo.deleteById(id);
    }

    private BuildingDto toDto(Building b) {
        int bottom = b.getBottomFloor();
        int top    = b.getTopFloor();

        // 1) 바닥~최고층 모든 층 생성
        List<String> floorsList = IntStream
                .rangeClosed(bottom, top)
                .mapToObj(FloorFormatter::format)
                .collect(Collectors.toList());

        // 2) DTO 필드용 포맷팅
        String topStr    = FloorFormatter.format(top);    // 최고층
        String bottomStr = FloorFormatter.format(bottom); // 최하층

        // 3) 생성자 인자 순서에 맞춰 topStr, bottomStr 를 바꿔서 전달
        return new BuildingDto(
                b.getId(),             // Long
                b.getBuildingName(),   // String
                floorsList,            // List<String>
                topStr,                // topFloor
                bottomStr,             // bottomFloor
                b.getIsPublic()        // Boolean
        );
    }
}
