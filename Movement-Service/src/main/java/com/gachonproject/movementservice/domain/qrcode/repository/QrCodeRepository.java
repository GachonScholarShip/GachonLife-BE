package com.gachonproject.movementservice.domain.qrcode.repository;

import com.gachonproject.movementservice.domain.qrcode.entity.QrCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QrCodeRepository extends JpaRepository<QrCode, Long> {

    boolean existsByBuildingName(String buildingName);
}
