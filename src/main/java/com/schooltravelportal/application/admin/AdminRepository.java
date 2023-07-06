package com.schooltravelportal.application.admin;

import com.schooltravelportal.application.tables.Admin;
import org.springframework.data.repository.CrudRepository;

public interface AdminRepository extends CrudRepository<Admin, Long> {

}
