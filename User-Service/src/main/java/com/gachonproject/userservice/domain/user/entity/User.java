package com.gachonproject.userservice.domain.user.entity;

import com.gachonproject.userservice.domain.user.dto.request.UserCreateDto;
import com.gachonproject.userservice.global.common.entity.BaseEntity;
import com.gachonproject.userservice.global.common.entity.enums.Role;
import com.gachonproject.userservice.global.common.entity.enums.Sex;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Getter
@SuperBuilder
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "student_id", unique = true)
    private String studentId;

    @Column(name = "login_id", unique = true)
    private String loginId;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Enumerated(EnumType.STRING)
    private Sex sex;

    public static User of(UserCreateDto dto, BCryptPasswordEncoder encoder) {
        return User.builder()
                .username(dto.username())
                .email(dto.email())
                .password(encoder.encode(dto.password()))
                .studentId(dto.studentId())
                .loginId(dto.loginId())
                .role(Role.USER)
                .sex(dto.sex())
                .build();

    }

}
