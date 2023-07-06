package com.schooltravelportal.application.tables;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "SCHEDULE")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String description;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "offer_details_id", referencedColumnName = "id")
    private OfferDetails offerDetails;

}
