package com.gachonproject.userservice.domain.user.entity;

import com.gachonproject.userservice.global.common.entity.BaseEntity;
import com.gachonproject.userservice.global.common.entity.enums.Role;
import com.gachonproject.userservice.global.common.entity.enums.Sex;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@SuperBuilder
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

    private String username;

    private String email;

    private String password;

    private String studentId;

    private String loginId;

    private Role role;

    private Sex sex;

}
