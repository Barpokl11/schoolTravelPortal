package com.schooltravelportal.application.user;

import com.schooltravelportal.application.domain.UserSample;
import com.schooltravelportal.application.exceptions.NotFoundException;
import com.schooltravelportal.application.tables.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServiceTest {
    @Autowired UserRepository userRepository;

    @Test
    void should_create_user() {
        //given
        final User userToDatabase = new UserSample().build();

        userRepository.save(userToDatabase);
        //when
        final User userFromDatabase = userRepository.findById(userToDatabase.getId()).orElseThrow(
                () -> new NotFoundException("This user is not exist in database")
        );
        //then
        assertThat(userFromDatabase).satisfies(fieldUserFromDatabase -> {
            assertThat(fieldUserFromDatabase.getEmail()).isEqualTo(userToDatabase.getEmail());
            assertThat(fieldUserFromDatabase.getLogin()).isEqualTo(userToDatabase.getLogin());
            assertThat(fieldUserFromDatabase.getPassword()).isEqualTo(userToDatabase.getPassword());
            assertThat(fieldUserFromDatabase.getFirstName()).isEqualTo(userToDatabase.getFirstName());
            assertThat(fieldUserFromDatabase.getLastName()).isEqualTo(userToDatabase.getLastName());
            assertThat(fieldUserFromDatabase.getSchool()).isEqualTo(userToDatabase.getSchool());
        });
    }

}