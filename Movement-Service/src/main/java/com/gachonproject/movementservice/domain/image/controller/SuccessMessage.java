package com.gachonproject.movementservice.domain.image.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SuccessMessage {

    PRESIGNED_URL_GENERATE_SUCCESS("Presigned url 발급에 성공했습니다.");

    private final String message;

}