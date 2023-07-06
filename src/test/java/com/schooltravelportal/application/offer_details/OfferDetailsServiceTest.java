package com.schooltravelportal.application.offer_details;

import com.schooltravelportal.application.domain.OfferDashboardSample;
import com.schooltravelportal.application.domain.ScheduleSample;
import com.schooltravelportal.application.domain.UpdateDashboardDtoSample;
import com.schooltravelportal.application.domain.UpdateDetailsSampleDto;
import com.schooltravelportal.application.exceptions.NotFoundException;
import com.schooltravelportal.application.offer_dashboard.CreateOfferDashboardDto;
import com.schooltravelportal.application.offer_dashboard.OfferDashboardService;
import com.schooltravelportal.application.schedule.CreateScheduleDto;
import com.schooltravelportal.application.schedule.ScheduleRepository;
import com.schooltravelportal.application.schedule.ScheduleService;
import com.schooltravelportal.application.tables.OfferDetails;
import com.schooltravelportal.application.tables.Schedule;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OfferDetailsServiceTest {
    @Autowired private OfferDetailsRepository repository;

    @Autowired private OfferDetailsService service;

    @Autowired private OfferDashboardService dashboardService;

    @Autowired private ScheduleService scheduleService;
    @Autowired private ScheduleRepository scheduleRepository;

    @Test
    void should_updateDetails() {
        //given
        final CreateOfferDashboardDto createDataDto = new OfferDashboardSample().build();
        dashboardService.createDashboardAndCommonFieldInDetails(createDataDto);

        final OfferDetails detalsBeforeUpdate = repository.findById(dashboardService
                .createDashboardAndCommonFieldInDetails(createDataDto).getId()).orElseThrow(
                () -> new NotFoundException("Not found this details"));
        final UpdateDetailsDto detailsToUpdate = new UpdateDetailsSampleDto().build(detalsBeforeUpdate
                .getInternalCode());


        //when
        service.updateDetails(detailsToUpdate);
        final OfferDetails detailsAfterUpdate = repository.getOfferDetailsByInternalCode(detailsToUpdate.getInternalCode
                ()).orElseThrow(() -> new NotFoundException("Not found this details"));
        //then
        assertThat(detailsAfterUpdate.getLimitPerson()).isNotEqualTo(detalsBeforeUpdate.getLimitPerson());
        assertThat(detailsAfterUpdate.getInternalCode()).isEqualTo(detalsBeforeUpdate.getInternalCode());

    }

    @Test
    @Disabled
    void should_createSchedule() {
        //given
        final CreateOfferDashboardDto createDataDto = new OfferDashboardSample().build();
        dashboardService.createDashboardAndCommonFieldInDetails(createDataDto);

        final OfferDetails detalsBeforeUpdate = repository.findById(dashboardService
                .createDashboardAndCommonFieldInDetails(createDataDto).getId()).orElseThrow(
                () -> new NotFoundException("Not found this details"));

        final CreateScheduleDto scheduleDto = new ScheduleSample().build(detalsBeforeUpdate.getId(),
                detalsBeforeUpdate.getInternalCode());

        //when
        service.createSchedules(scheduleDto);
        final OfferDetails detailsAfterUpdate = repository.findById(dashboardService
                .createDashboardAndCommonFieldInDetails(createDataDto).getId()).orElseThrow(
                () -> new NotFoundException("Not found this details"));
        //then
      //  assertTrue(detalsBeforeUpdate.getScheduleList().isEmpty());
        assertFalse(detailsAfterUpdate.getScheduleList().isEmpty());
    }
}