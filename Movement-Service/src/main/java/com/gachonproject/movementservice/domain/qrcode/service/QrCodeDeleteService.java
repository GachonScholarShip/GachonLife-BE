package com.gachonproject.movementservice.domain.qrcode.service;

import com.gachonproject.movementservice.domain.qrcode.entity.QrCode;
import com.gachonproject.movementservice.domain.qrcode.repository.QrCodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QrCodeDeleteService {

    private final QrCodeRepository qrCodeRepository;

    public void delete(QrCode qrCode) {
        qrCodeRepository.delete(qrCode);
    }
}
