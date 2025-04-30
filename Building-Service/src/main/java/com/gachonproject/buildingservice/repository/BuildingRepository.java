package com.gachonproject.buildingservice.repository;

import com.gachonproject.buildingservice.domain.Building;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BuildingRepository extends JpaRepository<Building,Long> {
    Optional<Building> findByBuildingName(String buildingName);
    boolean existsByBuildingName(String buildingName);
}
