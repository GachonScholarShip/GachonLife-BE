package com.gachonproject.movementservice.domain.mudang.repository;

import com.gachonproject.movementservice.domain.mudang.entity.Mudang;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MudangRepository extends JpaRepository<Mudang, Long> {

    Optional<Mudang> findMudangByTimeslot(String timeslot);

    Optional<Mudang> findFirstByTimeslotGreaterThanOrderByTimeslotAsc(String timeslot);

    List<Mudang> findMudangByOrderByTimeslotAsc(Pageable pageable);

}
