package com.schooltravelportal.application.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserDto {
    private String email;
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String school;
}
