package com.schooltravelportal.application.offer_dashboard;

import com.schooltravelportal.application.exceptions.NotFoundException;
import com.schooltravelportal.application.offer_details.OfferDetailsRepository;
import com.schooltravelportal.application.tables.OfferDashboard;
import com.schooltravelportal.application.tables.OfferDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import static java.util.Optional.ofNullable;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OfferDashboardService {
    private final OfferDetailsRepository detailsRepository;
    private final OfferDashboardRepository dashboardRepository;

    @Transactional
    public OfferDashboard createDashboardAndCommonFieldInDetails(final CreateOfferDashboardDto createDto) {
        final String internalCode = UUID.randomUUID().toString();
        final OfferDashboard offerDashboard = getOfferDashboard(createDto, internalCode);
        final OfferDetails offerDetails = getOfferDetails(offerDashboard, internalCode);
        dashboardRepository.save(offerDashboard);
        detailsRepository.save(offerDetails);
        return offerDashboard;
    }
    @Transactional
    public OfferDashboard updateDashboardAndCommonFieldInDetails(final UpdateDashboardDto updateDashboardDto) {
        final OfferDashboard dashboardToUpdate = updateDashboard(updateDashboardDto);
        final OfferDetails detailsToUpdate = updateCommonFieldInDetails(updateDashboardDto);

        dashboardRepository.save(dashboardToUpdate);
        detailsRepository.save(detailsToUpdate);

        return dashboardToUpdate;
    }
    public List<OfferDashboard> getAllDashboards() {
        return (List<OfferDashboard>) dashboardRepository.findAll();
    }

    public List<OfferDashboard> getOfferDashboardsSortedByTitle() {
        return dashboardRepository.getOfferDashboardsSortedByTitle();
    }

    public List<OfferDashboard> getOfferDashboardsByPriceAscending() {
        return dashboardRepository.getOfferDashboardsByPriceAscending();
    }


    public List<OfferDashboard> getOfferDashboardsByPriceDescending() {
        return dashboardRepository.getOfferDashboardsByPriceDescending();
    }

    public List<OfferDashboard> getOfferDashboardsByCurrencyPerPersonAscending() {
        return dashboardRepository.getOfferDashboardsByCurrencyPerPersonAscending();
    }

    public List<OfferDashboard> getOfferDashboardsByCurrencyPerPersonDescending() {
        return dashboardRepository.getOfferDashboardsByCurrencyPerPersonDescending();
    }

    public List<OfferDashboard> getOfferDashboardsSelectedByCountry(final String country) {
        return dashboardRepository.getDashboardSelectedByCountry(country);
    }


    private OfferDashboard getOfferDashboard(final CreateOfferDashboardDto dto, final String internalCode) {
        return OfferDashboard.builder()
                .internalCode(internalCode)
                .startJourney(dto.getStartJourney())
                .endJourney(dto.getEndJourney())
                .title(dto.getTitle())
                .subtitle(dto.getSubtitle())
                .country(dto.getCountry())
                .price(dto.getPrice())
                .currencyPerPerson(dto.getCurrencyPerPerson())
                .build();
    }

    private OfferDetails getOfferDetails(final OfferDashboard dto, final String internalCode) {
        return OfferDetails.builder()
                .internalCode(internalCode)
                .startJourney(dto.getStartJourney())
                .endJourney(dto.getEndJourney())
                .title(dto.getTitle())
                .subtitle(dto.getSubtitle())
                .country(dto.getCountry())
                .price(dto.getPrice())
                .currencyPerPerson(dto.getCurrencyPerPerson())
                .build();
    }

    private OfferDashboard updateDashboard(final UpdateDashboardDto updateDashboardDto) {
        final OfferDashboard dashboardToUpdate = dashboardRepository.getOfferDashboardByInternalCode(
                updateDashboardDto.getInternalCode()).orElseThrow(() -> new NotFoundException("Not found dashboard by " +
                "this code "));

        dashboardToUpdate.setStartJourney(ofNullable(updateDashboardDto.getStartJourney()).orElse(
                dashboardToUpdate.getStartJourney()));
        dashboardToUpdate.setEndJourney(ofNullable(updateDashboardDto.getEndJourney()).orElse(
                dashboardToUpdate.getEndJourney()));
        dashboardToUpdate.setTitle(ofNullable(updateDashboardDto.getTitle()).orElse(
                dashboardToUpdate.getTitle()));
        dashboardToUpdate.setSubtitle(ofNullable(updateDashboardDto.getSubtitle()).orElse(
                dashboardToUpdate.getSubtitle()));
        dashboardToUpdate.setCountry(ofNullable(updateDashboardDto.getCountry()).orElse(
                dashboardToUpdate.getCountry()));
        dashboardToUpdate.setPrice(ofNullable(updateDashboardDto.getPrice()).orElse(
                dashboardToUpdate.getPrice()));
        dashboardToUpdate.setCurrencyPerPerson(ofNullable(updateDashboardDto.getCurrencyPerPerson()).orElse(
                dashboardToUpdate.getCurrencyPerPerson()));


        return dashboardToUpdate;
    }
    private OfferDetails updateCommonFieldInDetails(final UpdateDashboardDto updateDashboardDto) {
        final OfferDetails detailsToUpdate = detailsRepository.getOfferDetailsByInternalCode(
                updateDashboardDto.getInternalCode()).orElseThrow(() -> new NotFoundException("Not found dashboard by "
                + "this code "));

        detailsToUpdate.setStartJourney(ofNullable(updateDashboardDto.getStartJourney()).orElse(
                detailsToUpdate.getStartJourney()));
        detailsToUpdate.setEndJourney(ofNullable(updateDashboardDto.getEndJourney()).orElse(
                detailsToUpdate.getEndJourney()));
        detailsToUpdate.setTitle(ofNullable(updateDashboardDto.getTitle()).orElse(
                detailsToUpdate.getTitle()));
        detailsToUpdate.setSubtitle(ofNullable(updateDashboardDto.getSubtitle()).orElse(
                detailsToUpdate.getSubtitle()));
        detailsToUpdate.setCountry(ofNullable(updateDashboardDto.getCountry()).orElse(
                detailsToUpdate.getCountry()));
        detailsToUpdate.setPrice(ofNullable(updateDashboardDto.getPrice()).orElse(
                detailsToUpdate.getPrice()));
        detailsToUpdate.setCurrencyPerPerson(ofNullable(updateDashboardDto.getCurrencyPerPerson()).orElse(
                detailsToUpdate.getCurrencyPerPerson()));


        return detailsToUpdate;
    }




}
