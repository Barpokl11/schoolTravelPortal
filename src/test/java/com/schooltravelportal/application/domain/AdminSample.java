package com.schooltravelportal.application.domain;

import com.schooltravelportal.application.tables.Admin;
import lombok.Builder;

import java.util.UUID;

public class AdminSample {
    @Builder
    public Admin build() {
        return Admin.builder()
                .email(UUID.randomUUID().toString())
                .login(UUID.randomUUID().toString())
                .password(UUID.randomUUID().toString())
                .build();
    }
}
