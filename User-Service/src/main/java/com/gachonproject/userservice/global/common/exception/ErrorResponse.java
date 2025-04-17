package com.gachonproject.userservice.global.common.exception;


import lombok.Builder;

@Builder
public record ErrorResponse(

        String errorField,
        String errorMessage,
        Object inputValue

) {
}