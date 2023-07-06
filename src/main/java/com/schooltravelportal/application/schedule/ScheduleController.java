package com.schooltravelportal.application.schedule;

import com.schooltravelportal.application.tables.Schedule;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("schedule")
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService service;


}
