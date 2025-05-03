package com.gachonproject.movementservice.domain.qrcode.service;

import com.gachonproject.movementservice.domain.qrcode.entity.QrCode;
import com.gachonproject.movementservice.domain.qrcode.exception.DuplicatedBuildingNameException;
import com.gachonproject.movementservice.domain.qrcode.exception.QrCodeNotFoundException;
import com.gachonproject.movementservice.domain.qrcode.repository.QrCodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QrCodeGetService {

    private final QrCodeRepository qrCodeRepository;

    public void isDuplicatedBuildinName(String buildingName) {
        if(qrCodeRepository.existsByBuildingName(buildingName)){
            throw new DuplicatedBuildingNameException();
        }
    }

    public QrCode findByBuildingName(String buildingName) {
        return qrCodeRepository.findByBuildingName(buildingName)
                .orElseThrow(QrCodeNotFoundException::new);
    }

    public QrCode findByQrCodeId(Long qrCodeId) {
        return qrCodeRepository.findById(qrCodeId)
                .orElseThrow(QrCodeNotFoundException::new);
    }

    public List<QrCode> findQrCodeList(Pageable pageable) {

        return qrCodeRepository.findAll(pageable).getContent();
    }
}
