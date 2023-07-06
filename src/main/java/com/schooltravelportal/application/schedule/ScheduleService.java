package com.schooltravelportal.application.schedule;

import com.schooltravelportal.application.exceptions.NotFoundException;
import com.schooltravelportal.application.offer_details.OfferDetailsRepository;
import com.schooltravelportal.application.tables.OfferDetails;
import com.schooltravelportal.application.tables.Schedule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleRepository repository;
    private final OfferDetailsRepository detailsRepository;


}
