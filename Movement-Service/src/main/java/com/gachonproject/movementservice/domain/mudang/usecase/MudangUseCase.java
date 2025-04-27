package com.gachonproject.movementservice.domain.mudang.usecase;

import com.gachonproject.movementservice.domain.mudang.dto.request.MudangSaveDto;
import com.gachonproject.movementservice.domain.mudang.dto.request.MudangUpdateDto;
import com.gachonproject.movementservice.domain.mudang.entity.Mudang;
import com.gachonproject.movementservice.domain.mudang.exception.LargeBusRunException;
import com.gachonproject.movementservice.domain.mudang.service.MudangDeleteService;
import com.gachonproject.movementservice.domain.mudang.service.MudangGetService;
import com.gachonproject.movementservice.domain.mudang.service.MudangSaveService;
import com.gachonproject.movementservice.domain.mudang.service.MudangUpdateService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@Service
@RequiredArgsConstructor
public class MudangUseCase {

    private static final String TIME_FORMAT = "HH:mm";
    private static final String RESPONSE_FORMAT = "%s분 무당이가 %s분 뒤 도착 예정입니다.";

    private final MudangSaveService mudangSaveService;
    private final MudangGetService mudangGetService;
    private final MudangUpdateService mudangUpdateService;
    private final MudangDeleteService mudangDeleteService;

    public void createMudang(MudangSaveDto dto) {

        mudangGetService.checkValidTime(dto.timeslot());

        mudangSaveService.saveMudang(Mudang.from(dto));
    }



}
