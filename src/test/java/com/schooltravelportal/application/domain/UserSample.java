package com.schooltravelportal.application.domain;

import com.schooltravelportal.application.tables.User;
import lombok.Builder;

import java.util.UUID;

public class UserSample {
    @Builder
    public User build() {
        return User.builder()
                .email(UUID.randomUUID().toString())
                .login(UUID.randomUUID().toString())
                .password(UUID.randomUUID().toString())
                .firstName(UUID.randomUUID().toString())
                .lastName(UUID.randomUUID().toString())
                .school(UUID.randomUUID().toString())
                .build();
    }
}
