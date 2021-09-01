package com.example.company;

import com.example.company.model.Company;
import com.example.company.model.Employee;
import com.example.company.model.EmployeeType;
import com.example.company.repository.CompanyRepository;
import com.example.company.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class CompanyEmployeeSpringApplication implements CommandLineRunner {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public static void main(String[] args) {

        SpringApplication.run(CompanyEmployeeSpringApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {

        if (!employeeRepository.findByEmail("admin@gmail.com").isPresent()){
            Company company = companyRepository.save(Company.builder()
                    .name("Default")
                    .address("Default")
                    .build());


            employeeRepository.save(Employee.builder()
                    .email("admin@gmail.com")
                    .name("admin")
                    .surname("admin")
                    .phoneNumber("098989898")
                    .password(passwordEncoder.encode("admin"))
                    .position("admin")
                    .employeeType(EmployeeType.ADMIN)
                    .company(company)
                    .build());
        }

    }

    @Bean
    public PasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder();
    }


}
