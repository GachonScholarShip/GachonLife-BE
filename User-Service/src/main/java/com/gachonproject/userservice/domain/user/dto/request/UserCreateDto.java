package com.gachonproject.userservice.domain.user.dto.request;

import com.gachonproject.userservice.global.common.entity.enums.Sex;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserCreateDto(

        @NotBlank(message = "이름을 입력해주세요.") String username,
        @NotBlank(message = "이메일을 입력해주세요. ") String email,
        @NotBlank(message = "비밀번호를 입력해주세요. ") String password,
        @NotBlank(message = "학번을 입력해주세요. ") String studentId,
        @NotNull(message = "성별을 입력해주세요. (MALE, FEMALE)") Sex sex,
        @NotBlank(message = "ID를 입력해주세요.") String loginId

) {
}
