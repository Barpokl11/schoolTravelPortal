package com.schooltravelportal.application.user;

import com.schooltravelportal.application.tables.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface UserRepository extends CrudRepository<User, Long> {

    @Query(value = "SELECT * FROM USER u WHERE u.email = :email", nativeQuery = true)
    Optional<User> findByLogin(@Param("email") final String email);
}
