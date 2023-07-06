package com.schooltravelportal.application.offer_dashboard;

import com.schooltravelportal.application.tables.OfferDashboard;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("dashboard")
@RequiredArgsConstructor
@CrossOrigin
public class OfferDashboardController {

    private final OfferDashboardService service;

    @PostMapping("create")
    public OfferDashboard createOfferDetails(@RequestBody final CreateOfferDashboardDto detailsDto) {
        return service.createDashboardAndCommonFieldInDetails(detailsDto);
    }

    @PutMapping("update")
    public OfferDashboard updateDataInDashboard(@RequestBody final UpdateDashboardDto updateDashboardDto) {
        return service.updateDashboardAndCommonFieldInDetails(updateDashboardDto);
    }

    @GetMapping("getAll")
    public List<OfferDashboard> getAllDashboards() {
        return service.getAllDashboards();
    }

    @GetMapping("sortByTitle")
    public List<OfferDashboard> sortDashboardsByTitle() {
        return service.getOfferDashboardsSortedByTitle();
    }

    @GetMapping("sortByPriceAsc")
    public List<OfferDashboard> sortDashboardsByPriceAscending() {
        return service.getOfferDashboardsByPriceAscending();
    }

    @GetMapping("sortByPriceDesc")
    public List<OfferDashboard> sortDashboardsByPriceDescending() {
        return service.getOfferDashboardsByPriceDescending();
    }

    @GetMapping("sortByCurrencyPPAsc")
    public List<OfferDashboard> sortDashboardsByCurrencyPerPersonAscending() {
        return service.getOfferDashboardsByCurrencyPerPersonAscending();
    }

    @GetMapping("sortByCurrencyPPDesc")
    public List<OfferDashboard> sortDashboardsByCurrencyPerPersonDescending() {
        return service.getOfferDashboardsByCurrencyPerPersonDescending();
    }

    @GetMapping("country")
    public List<OfferDashboard> selectDashboardsByCountry(@RequestParam String country) {
        return service.getOfferDashboardsSelectedByCountry(country);
    }


}
