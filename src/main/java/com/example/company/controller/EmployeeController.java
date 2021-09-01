package com.example.company.controller;

import com.example.company.model.Company;
import com.example.company.model.Employee;
import com.example.company.security.CurrentUser;
import com.example.company.service.CompanyService;
import com.example.company.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;
    private final CompanyService companyService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/employee")
    public String employee(ModelMap modelMap, @AuthenticationPrincipal CurrentUser currentUser) {
        List<Employee> employeeAll = employeeService.findEmployeesByCompanyId(currentUser.getEmployee().getCompany().getId());
        modelMap.addAttribute("employees", employeeAll);
        return "employee";
    }

    @GetMapping("/addEmployee")
    public String addEmployee(ModelMap modelMap){
        List<Company> allCompany = companyService.findAllCompanys();
        modelMap.addAttribute("companys", allCompany);
        return "addEmployee";
    }
    @PostMapping("/addEmployee")
    public  String addEmployee(@ModelAttribute Employee employee){
            employee.setPassword(passwordEncoder.encode(employee.getPassword()));
            employeeService.save(employee);
            Company company = companyService.getById(employee.getCompany().getId());
            company.setSize(company.getSize()+1);
            companyService.addCompany(company);
        return "redirect:/employee";
    }



}
