package com.schooltravelportal.application.user;

import com.schooltravelportal.application.tables.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    @Transactional
    public User createUser(final CreateUserDto dto) {
        final User createdUser = User.builder()
                .email(dto.getEmail())
                .login(dto.getLogin())
                .password(dto.getPassword())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .school(dto.getSchool())
                .build();
        repository.save(createdUser);
        return createdUser;
    }

    @Transactional
    public User updatePassword(final UpdateUserDto updateUserDto) {
        final User userForUpdate = repository.findByLogin(updateUserDto.getEmail()).orElseThrow(() ->
                new IllegalArgumentException("Not found the user by this login"));
        userForUpdate.setPassword(updateUserDto.getPassword());
        repository.save(userForUpdate);
        return userForUpdate;
    }
}
