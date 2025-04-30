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
@RequiredArgsConstructor
public class UserController {

    private final UserUseCase userUseCase;

    @GetMapping("/admin/user")
    public ApiResponse<List<UserResponseDto>> getUserList(@RequestParam(defaultValue = "0", required = false) int pageNum,
                                                          @RequestParam(defaultValue = "5", required = false) int pageSize) {

        List<UserResponseDto> response = userUseCase.findUserList(pageNum, pageSize);

        return ApiResponse.response(OK, USER_LIST_SUCCESS.getMessage(), response);
    }

    @PatchMapping("/admin/user")
    public ApiResponse<Void> updateUser(@RequestBody UserUpdateDto dto) {

        userUseCase.updateUser(dto);

        return ApiResponse.response(OK, USER_UPDATE_SUCCESS.getMessage());
    }

    @DeleteMapping("/admin/user/{userId}")
    public ApiResponse<Void> deleteUser(@PathVariable Long userId) {

        userUseCase.deleteUser(userId);

        return ApiResponse.response(OK, USER_DELETE_SUCCESS.getMessage());
    }

    @GetMapping("/normal/login_id/{loginId}")
    public ApiResponse<Boolean> checkLoginId(@PathVariable String loginId) {

        if (userUseCase.checkLoginId(loginId)) {
            return ApiResponse.response(OK, LOGIN_ID_VALIDATE.getMessage(), true);
        }

        return ApiResponse.response(OK, LOGIN_ID_INVALIDATE.getMessage(), false);
    }
}
