package com.gachonproject.movementservice.domain.qrcode.usecase;

import com.gachonproject.movementservice.domain.qrcode.dto.QrCodeDetailDto;
import com.gachonproject.movementservice.domain.qrcode.dto.QrCodeDto;
import com.gachonproject.movementservice.domain.qrcode.entity.QrCode;
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

    public void createQrCode(QrCodeDto dto) {
        qrCodeGetService.isDuplicatedBuildinName(dto.buildingName());
        qrCodeSaveService.saveQrCode(dto);
    }

    public QrCodeDetailDto getQrCode(String buildingName) {

        QrCode findQrCode = qrCodeGetService.findByBuildingName(buildingName);

        return QrCodeDetailDto.from(findQrCode);
    }

    public void updateQrCode(QrCodeDetailDto dto) {
        qrCodeGetService.isDuplicatedBuildinName(dto.buildingName());

        QrCode findQrCode = qrCodeGetService.findByBuildingName(dto.buildingName());
        findQrCode.updateField(dto);
    }

    public void deleteQrCode(Long qrCodeId) {

        QrCode findQrCode = qrCodeGetService.findByQrCodeId(qrCodeId);
        qrCodeDeleteService.delete(findQrCode);
    }

}
