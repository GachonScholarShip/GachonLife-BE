package com.gachonproject.buildingservice.domain.classes.repository;

import com.gachonproject.buildingservice.domain.classes.entity.Classes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassesRepository extends JpaRepository<Classes, Long> {

    boolean existsByTitle(String title);

    Page<Classes> findByBuildingName(String buildingName, Pageable pageable);

    Page<Classes> findByBuildingNameAndFloor(String buildingName, String floor, Pageable pageable);

}
