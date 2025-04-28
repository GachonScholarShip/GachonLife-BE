package com.gachonproject.movementservice.domain.roadview.repository;

import com.gachonproject.movementservice.domain.roadview.entity.RoadView;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RoadViewRepository extends JpaRepository<RoadView, Long> {

    Optional<RoadView> findRoadViewByEndPoint(String entPoint);

    List<RoadView> findRoadViewAll(Pageable pageable);
}
