package com.gachonproject.movementservice.domain.qrcode.dto.request;

public record QrCodeSaveDto(
        String buildingName,
        String imageUrl
) {
}
