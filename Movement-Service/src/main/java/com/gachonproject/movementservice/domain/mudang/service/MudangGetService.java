package com.gachonproject.movementservice.domain.mudang.service;

import com.gachonproject.movementservice.domain.mudang.entity.Mudang;
import com.gachonproject.movementservice.domain.mudang.exception.DuplicatedMudangException;
import com.gachonproject.movementservice.domain.mudang.exception.MudangNotFoundException;
import com.gachonproject.movementservice.domain.mudang.exception.MudangTooLateException;
import com.gachonproject.movementservice.domain.mudang.repository.MudangRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MudangGetService {

    private final MudangRepository mudangRepository;

    public Mudang getMudang(String timeslot) {

        return mudangRepository.findFirstByTimeslotGreaterThanOrderByTimeslotAsc(timeslot)
                .orElseThrow(MudangTooLateException::new);
    }

    public Mudang getMudangByMudangId(Long id) {
        return mudangRepository.findById(id)
                .orElseThrow(MudangNotFoundException::new);
    }

    public void checkValidTime(String timeslot) {
        mudangRepository.findMudangByTimeslot(timeslot).ifPresent(mudang -> {
            throw new DuplicatedMudangException();
        });
    }
}
