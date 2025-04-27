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

    public String getMudangTime() {
        LocalTime now = LocalTime.now();
        checkIsLunchTime(now);

        String minusFiveMinute = getTimeToMinusRequestTime(now);
        Mudang mudang = mudangGetService.getMudang(minusFiveMinute);

        long abs = getAbsTime(minusFiveMinute, mudang);
        return String.format(RESPONSE_FORMAT, mudang.getTimeslot(), abs);
    }



    /*
    * refactor
    * */

    private static void checkIsLunchTime(LocalTime now) {
        LocalTime start = LocalTime.of(11, 50);
        LocalTime end = LocalTime.of(12, 50);

        if (!now.isBefore(start) && !now.isAfter(end)) {
            throw new LargeBusRunException();
        }
    }

    private long getAbsTime(String minusFiveMinute, Mudang mudang) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(TIME_FORMAT);
        LocalTime t1 = LocalTime.parse(minusFiveMinute, formatter);
        LocalTime t2 = LocalTime.parse(mudang.getTimeslot(), formatter);

        return Math.abs(Duration.between(t1, t2).toMinutes());
    }

    private String getTimeToMinusRequestTime(LocalTime now) {
        LocalTime requestTime = now.minusMinutes(5);

        String minusFiveMinute = requestTime.format(DateTimeFormatter.ofPattern(TIME_FORMAT));
        return minusFiveMinute;
    }

}
