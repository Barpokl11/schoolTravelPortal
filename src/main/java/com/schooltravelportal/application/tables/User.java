package com.schooltravelportal.application.tables;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(name = "UniqueNumberAndStatus",
        columnNames = { "login", "school" }) }, name = "USER")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String login;

    @Column
    private String password;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column(unique = true)
    private String school;

    @OneToMany(mappedBy = "user")
    private List<OfferDashboard> offerDashboards;



}
