package com.example.company.controller;

import com.example.company.model.Company;
import com.example.company.model.Employee;
import com.example.company.repository.CompanyRepository;
import com.example.company.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    CompanyRepository companyRepository;

    @GetMapping("/employee")
    public String employee(ModelMap modelMap) {
        List<Employee> employeeAll = employeeRepository.findAll();
        modelMap.addAttribute("employees", employeeAll);
        return "employee";
    }

    @GetMapping("/addEmployee")
    public String addEmployee(ModelMap modelMap){
        List<Company> allCompany = companyRepository.findAll();
        modelMap.addAttribute("companys", allCompany);
        return "addEmployee";
    }
    @PostMapping("/addEmployee")
    public  String addEmployee(@ModelAttribute Employee employee){
            employeeRepository.save(employee);
        return "redirect:/employee";
    }

}
