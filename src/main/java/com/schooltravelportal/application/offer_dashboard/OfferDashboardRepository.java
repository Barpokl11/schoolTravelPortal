package com.schooltravelportal.application.offer_dashboard;

import com.schooltravelportal.application.tables.OfferDashboard;
import com.schooltravelportal.application.tables.OfferDetails;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface OfferDashboardRepository extends CrudRepository<OfferDashboard, Long> {

    @Query(value = "SELECT * FROM OFFER_DASHBOARD o WHERE o.internal_code = :internalCode", nativeQuery = true)
    Optional<OfferDashboard> getOfferDashboardByInternalCode(@Param("internalCode") final String internalCode);

    @Query(value = "SELECT * FROM OFFER_DASHBOARD o ORDER BY o.title ASC", nativeQuery = true)
    List<OfferDashboard> getOfferDashboardsSortedByTitle();

    @Query(value = "SELECT * FROM OFFER_DASHBOARD o ORDER BY o.price ASC", nativeQuery = true)
    List<OfferDashboard> getOfferDashboardsByPriceAscending();

    @Query(value = "SELECT * FROM OFFER_DASHBOARD o ORDER BY o.price DESC", nativeQuery = true)
    List<OfferDashboard> getOfferDashboardsByPriceDescending();

    @Query(value = "SELECT * FROM OFFER_DASHBOARD o ORDER BY o.currency_per_person", nativeQuery = true)
    List<OfferDashboard> getOfferDashboardsByCurrencyPerPersonAscending();

    @Query(value = "SELECT * FROM OFFER_DASHBOARD o ORDER BY o.currency_per_person", nativeQuery = true)
    List<OfferDashboard> getOfferDashboardsByCurrencyPerPersonDescending();

    @Query(value = "SELECT * FROM OFFER_DASHBOARD o WHERE o.country = :country", nativeQuery = true)
    List<OfferDashboard> getDashboardSelectedByCountry(@Param("country") final String country);

}
