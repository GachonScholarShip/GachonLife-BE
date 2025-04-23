package com.gachonproject.userservice.domain.user.dto.request;

import com.gachonproject.userservice.global.common.entity.enums.Sex;

public record UserUpdateDto(
        Long userId,
        String username,
        Sex sex,
        String email,
        String studentId
) {
}
