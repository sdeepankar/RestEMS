package com.rest.springbootems.service.impl;

import com.rest.springbootems.model.Employee;
import com.rest.springbootems.repository.EmployeeRepository;
import com.rest.springbootems.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl  implements EmployeeService {

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {
        return null;
    }
}
