package com.schooltravelportal.application.domain;

import com.schooltravelportal.application.offer_details.UpdateDetailsDto;
import lombok.Builder;

import java.util.Random;

public class UpdateDetailsSampleDto {
    @Builder
    public UpdateDetailsDto build(String internalCode){
        return UpdateDetailsDto.builder()
                .internalCode(internalCode)
                .limitPerson(new Random().nextInt())
                .build();

    }
}
