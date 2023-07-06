package com.schooltravelportal.application.user;

import com.schooltravelportal.application.tables.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping("create")
    public User createUser(@RequestBody final CreateUserDto dto) {
        return service.createUser(dto);
    }

    @PutMapping("updatePsd")
    public User updatePassword(@RequestBody final UpdateUserDto updateUserDto) {
        return service.updatePassword(updateUserDto);
    }

}
