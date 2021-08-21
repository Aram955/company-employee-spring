package com.example.company.repository;

import com.example.company.model.Company;
import com.example.company.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository <Employee, Integer> {



}
