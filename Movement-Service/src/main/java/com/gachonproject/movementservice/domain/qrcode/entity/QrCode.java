package com.gachonproject.movementservice.domain.qrcode.entity;


import com.gachonproject.movementservice.domain.qrcode.dto.QrCodeDto;
import com.gachonproject.movementservice.global.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@Entity
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class QrCode extends BaseEntity {

    @Column(nullable = false, length = 50)
    private String buildingName;

    @Column(nullable = false, length = 512)
    private String imageUrl;

    public static QrCode from(QrCodeDto dto) {
        return QrCode.builder()
                .buildingName(dto.buildingName())
                .imageUrl(dto.imageUrl())
                .build();
    }

    public void updateField(QrCodeDto dto) {
        this.buildingName = dto.buildingName();
        this.imageUrl = dto.imageUrl();
    }

}
