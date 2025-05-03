package com.gachonproject.movementservice.domain.qrcode.dto;

import com.gachonproject.movementservice.domain.qrcode.entity.QrCode;
import lombok.Builder;

@Builder
public record QrCodeDetailDto(
        Long id,
        String buildingName,
        String imageUrl
) {
    public static QrCodeDetailDto from(QrCode qrCode) {
        return QrCodeDetailDto.builder()
                .id(qrCode.getId())
                .buildingName(qrCode.getBuildingName())
                .imageUrl(qrCode.getImageUrl())
                .build();
    }
}
