package com.gachonproject.movementservice.domain.roadview.service;

import com.gachonproject.movementservice.domain.roadview.dto.request.RoadViewSaveDto;
import com.gachonproject.movementservice.domain.roadview.exception.DuplicatedRoadViewException;
import com.gachonproject.movementservice.domain.roadview.repository.RoadViewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoadViewGetService {

    private final RoadViewRepository roadViewRepository;

    public void checkDuplicatedRoadView(String endPoint) {
        roadViewRepository.findRoadViewByEndPoint(endPoint)
                .orElseThrow(DuplicatedRoadViewException::new);
    }

}
