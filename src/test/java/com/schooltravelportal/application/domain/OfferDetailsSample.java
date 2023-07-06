package com.schooltravelportal.application.domain;

import com.schooltravelportal.application.offer_dashboard.CreateOfferDashboardDto;
import lombok.Builder;

import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

public class OfferDetailsSample {
    @Builder
    public CreateOfferDashboardDto build() {
        return CreateOfferDashboardDto.builder()
                .title(UUID.randomUUID().toString())
                .subtitle(UUID.randomUUID().toString())
                .startJourney(LocalDate.now())
                .endJourney(LocalDate.now().plusDays(3))
                .country(UUID.randomUUID().toString())
                .price(new Random().nextDouble())
                .currencyPerPerson(new Random().toString())
                .build();
    }
}
