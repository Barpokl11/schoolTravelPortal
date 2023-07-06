package com.schooltravelportal.application.offer_details;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOfferDetailsDto {
    private LocalDate startJourney;
    private LocalDate endJourney;
    private String title;
    private String subtitle;
    private String country;
    private Double price;
    private String currencyPerPerson;
    private Integer limitPerson;
}
