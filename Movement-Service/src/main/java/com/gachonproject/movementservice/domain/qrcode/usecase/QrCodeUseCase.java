package com.gachonproject.movementservice.domain.qrcode.usecase;

import com.gachonproject.movementservice.domain.qrcode.dto.request.QrCodeSaveDto;
import com.gachonproject.movementservice.domain.qrcode.entity.QrCode;
import com.gachonproject.movementservice.domain.qrcode.repository.QrCodeRepository;
import com.gachonproject.movementservice.domain.qrcode.service.QrCodeDeleteService;
import com.gachonproject.movementservice.domain.qrcode.service.QrCodeGetService;
import com.gachonproject.movementservice.domain.qrcode.service.QrCodeSaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QrCodeUseCase {

    private final QrCodeSaveService qrCodeSaveService;
    private final QrCodeGetService qrCodeGetService;
    private final QrCodeDeleteService qrCodeDeleteService;

    public void createQrCode(QrCodeSaveDto dto) {
        qrCodeGetService.isDuplicatedBuildinName(dto.buildingName());
        qrCodeSaveService.saveQrCode(dto);
    }

}
