package com.gachonproject.movementservice.domain.mudang.service;

import com.gachonproject.movementservice.domain.mudang.dto.request.MudangUpdateDto;
import com.gachonproject.movementservice.domain.mudang.entity.Mudang;
import com.gachonproject.movementservice.domain.mudang.repository.MudangRepository;
import jakarta.persistence.Table;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MudangUpdateService {

    private final MudangRepository mudangRepository;

    @Transactional
    public void updateMudang(Mudang mudang, String timeslot) {
        mudang.updateTimeslot(timeslot);
    }
}
