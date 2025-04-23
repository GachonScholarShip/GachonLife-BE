package com.gachonproject.userservice.global.auth.jwt;

import com.gachonproject.userservice.domain.user.entity.User;
import com.gachonproject.userservice.global.common.entity.enums.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomUserDetails implements UserDetails {

    private final User users;

    public CustomUserDetails(User user) {
        this.users = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collection = new ArrayList<>();

        collection.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {

                return users.getRole().toString();
            }
        });

        return collection;
    }

    @Override
    public String getPassword() {
        return users.getPassword();
    }

    @Override
    public String getUsername() {
        return users.getUsername();
    }

    public Role getRole() {
        return users.getRole();
    }

    public Long getUserId() {
        return users.getId();
    }

    public String getLoginId() {
        return users.getLoginId();
    }

    public String getStudentId() {
        return users.getStudentId();
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
