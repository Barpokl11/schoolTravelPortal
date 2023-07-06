package com.schooltravelportal.application.admin;

import com.schooltravelportal.application.tables.Admin;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin")
@RequiredArgsConstructor
public class AdminController {
    private final AdminService service;

    @PostMapping("create")
    public Admin createAdmin(@RequestBody CreateAdminDto adminDto) {
        return service.createAdmin(adminDto);
    }
}
