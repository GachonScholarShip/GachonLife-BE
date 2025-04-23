package com.gachonproject.userservice.domain.user.controller;

import com.gachonproject.userservice.domain.user.dto.request.UserCreateDto;
import com.gachonproject.userservice.domain.user.usecase.AuthUseCase;
import com.gachonproject.userservice.global.common.response.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.gachonproject.userservice.domain.user.controller.enums.ResponseMessage.REGISTER_SUCCESS;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthUseCase authUseCase;

    @PostMapping("/signup")
    public ApiResponse<Void> signUp(@RequestBody @Valid UserCreateDto dto) {

        authUseCase.signUp(dto);

        return ApiResponse.response(HttpStatus.OK, REGISTER_SUCCESS.getMessage());
    }

}
