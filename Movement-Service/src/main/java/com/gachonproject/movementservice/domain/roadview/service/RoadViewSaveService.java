package com.gachonproject.movementservice.domain.roadview.service;

import com.gachonproject.movementservice.domain.roadview.dto.request.RoadViewSaveDto;
import com.gachonproject.movementservice.domain.roadview.entity.RoadView;
import com.gachonproject.movementservice.domain.roadview.repository.RoadViewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoadViewSaveService {

    private final RoadViewRepository roadViewRepository;

    public void saveRoadView(RoadViewSaveDto dto) {
        roadViewRepository.save(RoadView.from(dto));
    }
}
