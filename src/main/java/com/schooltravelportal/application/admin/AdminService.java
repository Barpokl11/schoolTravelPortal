package com.schooltravelportal.application.admin;

import com.schooltravelportal.application.tables.Admin;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminRepository repository;

    @Transactional
    public Admin createAdmin(final CreateAdminDto adminDto) {
        final Admin createdAdmin = Admin.builder()
                .email(adminDto.getEmail())
                .login(adminDto.getLogin())
                .password(adminDto.getPassword())
                .build();
        repository.save(createdAdmin);
        return createdAdmin;
    }

}
