package com.gachonproject.movementservice.domain.roadview.repository;

import com.gachonproject.movementservice.domain.roadview.entity.RoadView;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoadViewRepository extends JpaRepository<RoadView, Long> {

    Optional<RoadView> findRoadViewByEndPoint(String entPoint);
}
