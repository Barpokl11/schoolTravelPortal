package com.schooltravelportal.application.offer_details;

import com.schooltravelportal.application.tables.OfferDetails;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface OfferDetailsRepository extends CrudRepository<OfferDetails, Long> {

    @Query(value = "SELECT * FROM OFFER_DETAILS o WHERE o.internal_code = :internalCode", nativeQuery = true)
    Optional<OfferDetails> getOfferDetailsByInternalCode(@Param("internalCode") final String internalCode);



}
