package com.schooltravelportal.application.offer_details;

import com.schooltravelportal.application.schedule.CreateScheduleDto;
import com.schooltravelportal.application.tables.OfferDetails;
import com.schooltravelportal.application.tables.Schedule;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("details")
@RequiredArgsConstructor
@CrossOrigin
public class OfferDetailsController {
    private final OfferDetailsService service;
    private final OfferDetailsRepository repository;

    @PutMapping("update")
    public OfferDetails updateDetails(@RequestBody final UpdateDetailsDto updateDetailsDto) {
        return service.updateDetails(updateDetailsDto);
    }
    @GetMapping("getAll")
    public List<OfferDetails> getAllDetails() {
        return (List<OfferDetails>) repository.findAll();
    }
    @PostMapping("createScheduleForOfferDetails")
    public Schedule createSchedule(@RequestBody final CreateScheduleDto scheduleDto) {
        return service.createSchedules(scheduleDto);
    }



}
