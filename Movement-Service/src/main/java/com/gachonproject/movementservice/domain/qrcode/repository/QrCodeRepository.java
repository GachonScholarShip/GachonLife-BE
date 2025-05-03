package com.gachonproject.movementservice.domain.qrcode.repository;

import com.gachonproject.movementservice.domain.qrcode.entity.QrCode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QrCodeRepository extends JpaRepository<QrCode, Long> {

    boolean existsByBuildingName(String buildingName);

    Optional<QrCode> findByBuildingName(String buildingName);

}
