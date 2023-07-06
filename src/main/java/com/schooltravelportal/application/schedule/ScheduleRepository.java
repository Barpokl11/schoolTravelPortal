package com.schooltravelportal.application.schedule;

import com.schooltravelportal.application.tables.Schedule;
import org.springframework.data.repository.CrudRepository;

public interface ScheduleRepository extends CrudRepository<Schedule, Long> {
}
