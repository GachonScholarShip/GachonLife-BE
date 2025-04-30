package com.gachonproject.buildingservice.global.common.exception;

import lombok.Builder;

@Builder
public record ErrorResponse(
        String errorField,
        String errorMessage,
        Object inputValue
) {}
