package com.gachonproject.movementservice.domain.mudang.service;

import com.gachonproject.movementservice.domain.mudang.entity.Mudang;
import com.gachonproject.movementservice.domain.mudang.repository.MudangRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MudangDeleteService {

    private final MudangRepository mudangRepository;

    @Transactional
    public void deleteMudang(Mudang mudang) {
        mudangRepository.delete(mudang);
    }
}
