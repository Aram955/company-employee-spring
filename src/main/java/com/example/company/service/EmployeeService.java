package com.example.company.service;

import com.example.company.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<Employee> findAllEmployees();

    List<Employee> findEmployeesByCompanyId (int companyId);

    void save(Employee employee);

    void deleteAllByCompanyId(int id);

    Optional<Employee> findEmployeeById(int id);
}
