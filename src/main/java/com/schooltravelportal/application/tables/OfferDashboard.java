package com.schooltravelportal.application.tables;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "OFFER_DASHBOARD")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OfferDashboard {
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

    @OneToOne(mappedBy = "offerDashboard")
    private OfferDetails offerDetails;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "admin_id", referencedColumnName = "id")
    private Admin admin;
}
