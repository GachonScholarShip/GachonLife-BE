package com.gachonproject.movementservice.domain.mudang.service;

import com.gachonproject.movementservice.domain.mudang.entity.Mudang;
import com.gachonproject.movementservice.domain.mudang.repository.MudangRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MudangSaveService {

    private final MudangRepository mudangRepository;

    public void saveMudang(Mudang mudang) {
        mudangRepository.save(mudang);
    }

}
