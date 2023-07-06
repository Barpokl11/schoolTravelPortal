package com.schooltravelportal.application.domain;

import com.schooltravelportal.application.schedule.CreateScheduleDto;
import com.schooltravelportal.application.tables.OfferDetails;
import com.schooltravelportal.application.tables.Schedule;
import lombok.Builder;
import lombok.NonNull;

import java.util.UUID;

public class ScheduleSample {
    @Builder
    public CreateScheduleDto build(final Long id, final String internalCode) {
        return CreateScheduleDto.builder()
                .title(UUID.randomUUID().toString())
                .description(UUID.randomUUID().toString())
                .offerDetailsId(id)
                .internalCode(internalCode)
                .build();
    }
}
