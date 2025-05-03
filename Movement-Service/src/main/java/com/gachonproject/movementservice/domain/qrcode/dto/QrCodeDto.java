package com.gachonproject.movementservice.domain.qrcode.dto;

import com.gachonproject.movementservice.domain.qrcode.entity.QrCode;
import lombok.Builder;

@Builder
public record QrCodeDto(
        String buildingName,
        String imageUrl
) {
    public static QrCodeDto from(QrCode qrCode) {
        return QrCodeDto.builder()
                .buildingName(qrCode.getBuildingName())
                .imageUrl(qrCode.getImageUrl())
                .build();
    }
}
