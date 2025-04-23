package com.gachonproject.userservice.domain.user.dto.response;

import com.gachonproject.userservice.domain.user.entity.User;
import com.gachonproject.userservice.global.common.entity.enums.Sex;
import lombok.Builder;

@Builder
public record UserResponseDto(
        Long userId,
        String username,
        String email,
        Sex sex,
        String studentId
) {
    public static UserResponseDto from(User user) {
        return UserResponseDto.builder()
                .userId(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .sex(user.getSex())
                .studentId(user.getStudentId())
                .build();
    }
}
