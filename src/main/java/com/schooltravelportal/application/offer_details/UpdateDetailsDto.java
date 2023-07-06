package com.schooltravelportal.application.offer_details;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UpdateDetailsDto {
    private Integer limitPerson;
    private String internalCode;
}
