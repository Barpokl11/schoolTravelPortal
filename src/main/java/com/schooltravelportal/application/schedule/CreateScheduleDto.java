package com.schooltravelportal.application.schedule;

import com.schooltravelportal.application.tables.OfferDetails;
import com.schooltravelportal.application.tables.Schedule;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateScheduleDto {
    private String internalCode;
    private String title;
    private String description;
    private Long offerDetailsId;


}
