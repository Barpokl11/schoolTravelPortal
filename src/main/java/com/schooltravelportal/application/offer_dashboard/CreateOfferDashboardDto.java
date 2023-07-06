package com.schooltravelportal.application.offer_dashboard;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOfferDashboardDto {
    private String internalCode;
    private LocalDate startJourney;
    private LocalDate endJourney;
    private String title;
    private String subtitle;
    private String country;
    private Double price;
    private String currencyPerPerson;
}
