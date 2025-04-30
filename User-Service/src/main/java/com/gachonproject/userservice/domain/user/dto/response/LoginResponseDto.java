package com.gachonproject.userservice.domain.user.dto.response;

import lombok.Builder;

@Builder
public record LoginResponseDto(
        String role
) {
    public static LoginResponseDto from(String role) {
        return LoginResponseDto.builder()
                .role(role)
                .build();
    }
}
