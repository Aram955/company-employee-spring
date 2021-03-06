package com.example.company.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    private String email;
    private String  phoneNumber;
    private int salary;
    private String position;
    private String password;
    @Enumerated(value = EnumType.STRING)
    private EmployeeType employeeType;
    @ManyToOne(fetch = FetchType.EAGER)
    private Company company;
}
