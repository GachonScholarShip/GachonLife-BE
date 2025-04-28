package com.gachonproject.movementservice.domain.roadview.usecase;

import com.gachonproject.movementservice.domain.roadview.dto.request.RoadViewSaveDto;
import com.gachonproject.movementservice.domain.roadview.dto.response.RoadViewDetailDto;
import com.gachonproject.movementservice.domain.roadview.entity.RoadView;
import com.gachonproject.movementservice.domain.roadview.service.RoadViewGetService;
import com.gachonproject.movementservice.domain.roadview.service.RoadViewSaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoadViewUseCase {

    private final RoadViewSaveService roadViewSaveService;
    private final RoadViewGetService roadViewGetService;

    public void saveRoadView(RoadViewSaveDto dto) {

        roadViewGetService.checkDuplicatedRoadView(dto.endPoint());
        roadViewSaveService.saveRoadView(dto);

    }

    public RoadViewDetailDto getRoadViewDetail(String endPoint) {

        RoadView findRoadView = roadViewGetService.findRoadView(endPoint);

        return RoadViewDetailDto.from(findRoadView);
    }

    public List<RoadViewDetailDto> getRoadViewList(int pageNum, int pageSize) {

        Pageable pageable = PageRequest.of(pageNum, pageSize);

        return roadViewGetService.findRoadViewList(pageable)
                .stream()
                .map(RoadViewDetailDto::from)
                .toList();
    }

}
