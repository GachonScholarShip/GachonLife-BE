package com.gachonproject.movementservice.domain.qrcode.service;

import com.gachonproject.movementservice.domain.qrcode.exception.DuplicatedBuildingNameException;
import com.gachonproject.movementservice.domain.qrcode.repository.QrCodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QrCodeGetService {

    private final QrCodeRepository qrCodeRepository;

    public void isDuplicatedBuildinName(String buildingName) {
        if(qrCodeRepository.existsByBuildingName(buildingName)){
            throw new DuplicatedBuildingNameException();
        }
    }
}
