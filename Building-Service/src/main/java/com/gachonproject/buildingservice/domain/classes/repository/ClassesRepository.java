package com.gachonproject.buildingservice.domain.classes.repository;

import com.gachonproject.buildingservice.domain.classes.entity.Classes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassesRepository extends JpaRepository<Classes, Long> {

    boolean existsByTitle(String title);
}
