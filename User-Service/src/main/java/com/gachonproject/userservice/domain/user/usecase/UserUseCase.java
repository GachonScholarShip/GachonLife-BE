package com.gachonproject.userservice.domain.user.usecase;

import com.gachonproject.userservice.domain.user.dto.request.UserUpdateDto;
import com.gachonproject.userservice.domain.user.dto.response.UserResponseDto;
import com.gachonproject.userservice.domain.user.entity.User;
import com.gachonproject.userservice.domain.user.service.UserDeleteService;
import com.gachonproject.userservice.domain.user.service.UserGetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserUseCase {

    private final UserGetService userGetService;
    private final UserDeleteService userDeleteService;

    @Transactional(readOnly = true)
    public List<UserResponseDto> findUserList(int pageNum, int pageSize) {
        return userGetService.findUserList(pageNum, pageSize)
                .stream()
                .map(UserResponseDto::from)
                .toList();
    }

    @Transactional
    public void updateUser(UserUpdateDto dto){

        userGetService.validateStudentId(dto.studentId());

        User findUser = userGetService.findByUserId(dto.userId());
        findUser.updateField(dto);
    }

    public void deleteUser(Long userId){

        User findUser = userGetService.findByUserId(userId);

        userDeleteService.delete(findUser);
    }

    public boolean checkLoginId(String loginId){
        // 이미 존재하는 경우
        return !userGetService.validateLoginId(loginId);
    }

    public boolean checkStudentId(String studentId){
        // 이미 존재하는 경우
        return !userGetService.validateStudentId(studentId);
    }

}
