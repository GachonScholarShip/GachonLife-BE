package com.gachonproject.userservice.domain.user.usecase;

import com.gachonproject.userservice.domain.user.dto.request.UserCreateDto;
import com.gachonproject.userservice.domain.user.entity.User;
import com.gachonproject.userservice.domain.user.exception.LoginIdExistsException;
import com.gachonproject.userservice.domain.user.exception.StudentIdExistsException;
import com.gachonproject.userservice.domain.user.service.UserGetService;
import com.gachonproject.userservice.domain.user.service.UserSaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthUseCase {

    private final UserSaveService userSaveService;
    private final UserGetService userGetService;

    public void signUp(UserCreateDto dto) {
        validate(dto);

        userSaveService.save(User.of(dto));
    }

    /*
    * refactor
    * */

    private void validate(UserCreateDto dto){
        if(userGetService.validateLoginId(dto.loginId())){
            throw new LoginIdExistsException();
        }
        if(userGetService.validateStudentId(dto.studentId())){
            throw new StudentIdExistsException();
        }
    }

}
