package com.schooltravelportal.application.tables;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "OFFER_DETAILS")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OfferDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String internalCode;

    @Column
    private LocalDate startJourney;

    @Column
    private LocalDate endJourney;

    @Column
    private String title;

    @Column
    private String subtitle;

    @Column
    private String country;

    @Column
    private Double price;

    @Column
    private String currencyPerPerson;

    @Column
    private Integer limitPerson;

    @OneToOne
    @JoinColumn(name = "offer_dashboard_id", referencedColumnName = "id", unique = true)
    private OfferDashboard offerDashboard;

    @OneToMany(mappedBy = "offerDetails", cascade = CascadeType.PERSIST)
    private List<Schedule> scheduleList;

}
