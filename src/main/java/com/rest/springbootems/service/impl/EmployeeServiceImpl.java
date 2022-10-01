package com.rest.springbootems.service.impl;

import com.rest.springbootems.exception.ResourceNotFoundException;
import com.rest.springbootems.model.Employee;
import com.rest.springbootems.repository.EmployeeRepository;
import com.rest.springbootems.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl  implements EmployeeService {

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {

        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {
//        Optional<Employee> employee = employeeRepository.findById(id);
//        if(employee.isPresent()){
//            return employee.get();
//        }else {
//            throw new ResourceNotFoundException("Employee","Id", id);
//        }

        return employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee", "Id", id));
    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {

        //need to check whether employee with the id is present in DB or not
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee","Id",id));

        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());

        //save existing employee on DB
        employeeRepository.save(existingEmployee);
        return existingEmployee;
    }

    @Override
    public void deleteEmployee(long id) {
        employeeRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Employee","Id", id));

        employeeRepository.deleteById(id);
    }

}
