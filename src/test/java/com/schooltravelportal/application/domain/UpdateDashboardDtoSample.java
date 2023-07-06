package com.schooltravelportal.application.domain;

import com.schooltravelportal.application.offer_dashboard.UpdateDashboardDto;
import lombok.Builder;

import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

public class UpdateDashboardDtoSample {
    @Builder
    public UpdateDashboardDto build(String internalCode) {
        return UpdateDashboardDto.builder()
                .internalCode(internalCode)
                .title(UUID.randomUUID().toString())
                .subtitle(UUID.randomUUID().toString())
                .startJourney(LocalDate.now().plusDays(1))
                .endJourney(LocalDate.now().plusDays(4))
                .country(UUID.randomUUID().toString())
                .price(new Random().nextDouble())
                .currencyPerPerson(new Random().toString())
                .build();
    }
}
