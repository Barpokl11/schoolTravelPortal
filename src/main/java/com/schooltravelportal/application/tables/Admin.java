package com.schooltravelportal.application.tables;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table( name = "ADMIN")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String login;

    @Column
    private String password;

    @OneToMany(mappedBy = "admin")
    private List<OfferDashboard> offerDashboards;

}
