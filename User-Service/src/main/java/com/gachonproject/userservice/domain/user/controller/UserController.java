package com.gachonproject.userservice.domain.user.controller;

import com.gachonproject.userservice.domain.user.dto.request.UserUpdateDto;
import com.gachonproject.userservice.domain.user.dto.response.UserResponseDto;
import com.gachonproject.userservice.domain.user.usecase.UserUseCase;
import com.gachonproject.userservice.global.common.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.gachonproject.userservice.domain.user.controller.enums.ResponseMessage.*;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class UserController {

    private final UserUseCase userUseCase;

    @GetMapping("/user")
    public ApiResponse<List<UserResponseDto>> getUserList(@RequestParam(defaultValue = "0", required = false) int pageNumber,
                                                          @RequestParam(defaultValue = "0", required = false) int pageSize) {

        List<UserResponseDto> response = userUseCase.findUserList(pageNumber, pageSize);

        return ApiResponse.response(OK, USER_LIST_SUCCESS.getMessage(), response);
    }

}
