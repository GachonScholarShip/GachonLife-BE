package com.gachonproject.movementservice.domain.qrcode.dto.response;

import com.gachonproject.movementservice.domain.qrcode.entity.QrCode;
import lombok.Builder;

@Builder
public record QrCodeDetailDto(
        String buildingName,
        String imageUrl
) {
    public static QrCodeDetailDto from(QrCode qrCode) {
        return QrCodeDetailDto.builder()
                .buildingName(qrCode.getBuildingName())
                .imageUrl(qrCode.getImageUrl())
                .build();
    }
}
