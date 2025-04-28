package com.gachonproject.movementservice.domain.roadview.service;

import com.gachonproject.movementservice.domain.roadview.dto.request.RoadViewSaveDto;
import com.gachonproject.movementservice.domain.roadview.dto.response.RoadViewDetailDto;
import com.gachonproject.movementservice.domain.roadview.entity.RoadView;
import com.gachonproject.movementservice.domain.roadview.exception.DuplicatedRoadViewException;
import com.gachonproject.movementservice.domain.roadview.exception.RoadViewNotFoundException;
import com.gachonproject.movementservice.domain.roadview.repository.RoadViewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoadViewGetService {

    private final RoadViewRepository roadViewRepository;

    public void checkDuplicatedRoadView(String endPoint) {
        roadViewRepository.findRoadViewByEndPoint(endPoint)
                .orElseThrow(DuplicatedRoadViewException::new);
    }

    public RoadView findRoadView(String endPoint) {
        return roadViewRepository.findRoadViewByEndPoint(endPoint)
                .orElseThrow(RoadViewNotFoundException::new);
    }

    public List<RoadView> findRoadViewList(Pageable pageable) {
        return roadViewRepository.findRoadViewAll(pageable);
    }

}
