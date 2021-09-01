package com.example.company.service.impl;

import com.example.company.model.Employee;
import com.example.company.repository.CompanyRepository;
import com.example.company.repository.EmployeeRepository;
import com.example.company.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;



    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void deleteAllByCompanyId(int id){
        employeeRepository.deleteAllByCompanyId(id);
    }

    @Override
    public List<Employee> findEmployeesByCompanyId(int companyId) {
        return employeeRepository.findEmployeeByCompanyId(companyId);
    }

    @Override
    public Optional <Employee> findEmployeeById(int id){
        return employeeRepository.findById(id);
    }




}
