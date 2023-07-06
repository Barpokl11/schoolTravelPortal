package com.schooltravelportal.application.offer_dashboard;

import com.schooltravelportal.application.domain.OfferDashboardSample;
import com.schooltravelportal.application.domain.UpdateDashboardDtoSample;
import com.schooltravelportal.application.exceptions.NotFoundException;
import com.schooltravelportal.application.offer_details.OfferDetailsRepository;
import com.schooltravelportal.application.offer_details.UpdateDetailsDto;
import com.schooltravelportal.application.tables.OfferDashboard;
import com.schooltravelportal.application.tables.OfferDetails;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static java.util.Optional.ofNullable;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

@SpringBootTest
class OfferDashboardServiceInt {

    @Autowired
    private OfferDashboardRepository dashboardRepository;

    @Autowired
    private OfferDashboardService dashboardService;

    @Autowired
    private OfferDetailsRepository detailsRepository;

    @Test
    @Disabled
    void should_create_dashboard_and_details() {
        //given
        final CreateOfferDashboardDto createDataDto = new OfferDashboardSample().build();
        dashboardService.createDashboardAndCommonFieldInDetails(createDataDto);

        //when
        final OfferDashboard dashboardFromDatabase = dashboardRepository.findById(
                dashboardService.createDashboardAndCommonFieldInDetails(createDataDto).getId()
        ).orElseThrow(() -> new NotFoundException("This dashboard does not exist"));
        final OfferDetails detailsFromDatabase = detailsRepository.findById(dashboardFromDatabase.getId()).orElseThrow
                (() -> new NotFoundException("This details does not exist"));

        //then
        assertThat(dashboardFromDatabase).satisfies(fieldOfDashboard -> {
            assertThat(fieldOfDashboard.getInternalCode()).isEqualTo(detailsFromDatabase.getInternalCode());
            assertThat(fieldOfDashboard.getTitle()).isEqualTo(detailsFromDatabase.getTitle());
            assertThat(fieldOfDashboard.getSubtitle()).isEqualTo(detailsFromDatabase.getSubtitle());
            assertThat(fieldOfDashboard.getStartJourney()).isEqualTo(detailsFromDatabase.getStartJourney());
            assertThat(fieldOfDashboard.getEndJourney()).isEqualTo(detailsFromDatabase.getEndJourney());
            assertThat(fieldOfDashboard.getCountry()).isEqualTo(detailsFromDatabase.getCountry());
            assertThat(fieldOfDashboard.getPrice()).isEqualTo(detailsFromDatabase.getPrice());
            assertThat(fieldOfDashboard.getCurrencyPerPerson()).isEqualTo(detailsFromDatabase.getCurrencyPerPerson());
        });
    }

    @Test
    void should_update_dashboard_adn_details() {
        //given
        final CreateOfferDashboardDto createDataDto = new OfferDashboardSample().build();
        dashboardService.createDashboardAndCommonFieldInDetails(createDataDto);
        final OfferDashboard dashboardFromDatabase = dashboardRepository.findById(dashboardService
                        .createDashboardAndCommonFieldInDetails(createDataDto).getId())
                .orElseThrow(() -> new NotFoundException("This dashboard does not exist"));
        final UpdateDashboardDto dashboardToUpdate = new UpdateDashboardDtoSample().build(dashboardFromDatabase
                .getInternalCode());

        //when
        dashboardService.updateDashboardAndCommonFieldInDetails(dashboardToUpdate);
        final OfferDashboard modifiedDashboard = dashboardRepository.getOfferDashboardByInternalCode(
                        dashboardToUpdate.getInternalCode())
                .orElseThrow(() -> new NotFoundException("This dashboard does not exist"));
        //then
        assertThat(modifiedDashboard).satisfies(fieldOfDashboardToUpdate -> {
            assertThat(fieldOfDashboardToUpdate.getInternalCode()).isEqualTo(dashboardFromDatabase.getInternalCode());
            assertThat(fieldOfDashboardToUpdate.getTitle()).isNotEqualTo(dashboardFromDatabase.getInternalCode());
            assertThat(fieldOfDashboardToUpdate.getSubtitle()).isNotEqualTo(dashboardFromDatabase.getSubtitle());
            assertThat(fieldOfDashboardToUpdate.getStartJourney()).isNotEqualTo(dashboardFromDatabase.getStartJourney());
            assertThat(fieldOfDashboardToUpdate.getEndJourney()).isNotEqualTo(dashboardFromDatabase.getEndJourney());
            assertThat(fieldOfDashboardToUpdate.getCountry()).isNotEqualTo(dashboardFromDatabase.getCountry());
            assertThat(fieldOfDashboardToUpdate.getPrice()).isNotEqualTo(dashboardFromDatabase.getPrice());
            assertThat(fieldOfDashboardToUpdate.getCurrencyPerPerson()).isNotEqualTo(dashboardFromDatabase
                    .getCurrencyPerPerson());

        });

    }

    @Test
    void getOfferDashboardsSortedByTitle() {
        fail("failed");
    }

    @Test
    void getOfferDashboardsByPriceAscending() {
        fail("failed");

    }

    @Test
    void getOfferDashboardsByPriceDescending() {
        fail("failed");

    }

    @Test
    void getOfferDashboardsByCurrencyPerPersonAscending() {
        fail("failed");

    }

    @Test
    void getOfferDashboardsByCurrencyPerPersonDescending() {
        fail("failed");

    }

    @Test
    void getOfferDashboardsSelectedByCountry() {
        fail("failed");

    }
}