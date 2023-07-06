package com.schooltravelportal.application.admin;

import com.schooltravelportal.application.domain.AdminSample;
import com.schooltravelportal.application.exceptions.NotFoundException;
import com.schooltravelportal.application.tables.Admin;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AdminServiceTest {
    @Autowired AdminRepository adminRepository;

    @Test
    void should_create_Admin() {
        //given
        final Admin adminToDatabase = new AdminSample().build();

        adminRepository.save(adminToDatabase);
        //when
        final Admin adminFromDatabse = adminRepository.findById(adminToDatabase.getId()).orElseThrow(
                () -> new NotFoundException("Not found this admin in database")
        );
        //then
        assertThat(adminFromDatabse).satisfies(fieldAdminFromDatabase -> {
            assertThat(fieldAdminFromDatabase.getEmail()).isEqualTo(adminToDatabase.getEmail());
            assertThat(fieldAdminFromDatabase.getLogin()).isEqualTo(adminToDatabase.getLogin());
            assertThat(fieldAdminFromDatabase.getPassword()).isEqualTo(adminToDatabase.getPassword());
        });


    }
}