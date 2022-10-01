package com.rest.springbootems.repository;

import com.rest.springbootems.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee, Long> { }
