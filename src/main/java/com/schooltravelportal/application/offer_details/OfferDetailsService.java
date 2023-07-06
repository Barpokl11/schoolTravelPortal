package com.schooltravelportal.application.offer_details;

import com.schooltravelportal.application.exceptions.NotFoundException;
import com.schooltravelportal.application.schedule.CreateScheduleDto;
import com.schooltravelportal.application.schedule.ScheduleRepository;
import com.schooltravelportal.application.schedule.ScheduleService;
import com.schooltravelportal.application.tables.OfferDetails;
import com.schooltravelportal.application.tables.Schedule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

@Service
@RequiredArgsConstructor
public class OfferDetailsService {

    private final OfferDetailsRepository detailsRepository;
    private final ScheduleRepository scheduleRepository;

    @Transactional
    public OfferDetails updateDetails(final UpdateDetailsDto updateDetailsDto) {
        final OfferDetails detailsToUpdate = detailsRepository.getOfferDetailsByInternalCode(
                updateDetailsDto.getInternalCode()).orElseThrow(() -> new RuntimeException("Not found" +
                "this internal code"));

        detailsToUpdate.setLimitPerson(ofNullable(updateDetailsDto.getLimitPerson())
                .orElse(detailsToUpdate.getLimitPerson()));


        detailsRepository.save(detailsToUpdate);
        return detailsToUpdate;
    }
    public Schedule createSchedules(final CreateScheduleDto dto) {
        final OfferDetails offerDetails = detailsRepository.getOfferDetailsByInternalCode(dto.getInternalCode())
                .orElseThrow(() -> new NotFoundException("Not found this details")
                );
        final Schedule createdSchedule = Schedule.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .offerDetails(offerDetails)
                .build();
        scheduleRepository.save(createdSchedule);
        return createdSchedule;
    }




}
