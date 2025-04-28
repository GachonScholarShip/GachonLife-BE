package com.gachonproject.movementservice.domain.roadview.service;

import com.gachonproject.movementservice.domain.roadview.entity.RoadView;
import com.gachonproject.movementservice.domain.roadview.repository.RoadViewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RoadViewDeleteService {

    private final RoadViewRepository roadViewRepository;

    @Transactional
    public void delete(RoadView roadView) {
        roadViewRepository.delete(roadView);
    }
}
