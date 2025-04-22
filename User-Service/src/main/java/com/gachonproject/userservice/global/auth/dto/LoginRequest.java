package com.gachonproject.userservice.global.auth.dto;

public record LoginRequest(

        String loginId,
        String password

) {
}
