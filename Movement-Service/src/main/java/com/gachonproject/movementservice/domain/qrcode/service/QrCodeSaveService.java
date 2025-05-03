package com.gachonproject.movementservice.domain.qrcode.service;

import com.gachonproject.movementservice.domain.qrcode.dto.QrCodeDto;
import com.gachonproject.movementservice.domain.qrcode.entity.QrCode;
import com.gachonproject.movementservice.domain.qrcode.repository.QrCodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QrCodeSaveService {

    private final QrCodeRepository qrCodeRepository;

    public void saveQrCode(QrCodeDto dto) {
        qrCodeRepository.save(QrCode.from(dto));
    }

}
