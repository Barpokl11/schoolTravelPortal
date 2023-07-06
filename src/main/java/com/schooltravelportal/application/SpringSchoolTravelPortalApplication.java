package com.schooltravelportal.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SpringSchoolTravelPortalApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSchoolTravelPortalApplication.class, args);
    }
}
