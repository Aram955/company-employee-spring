package com.example.company.controller;

import com.example.company.model.Employee;
import com.example.company.repository.CompanyRepository;
import com.example.company.model.Company;
import com.example.company.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class CompanyController {

    @Autowired
    private CompanyRepository companyRepository;
    private EmployeeRepository employeeRepository;

    @GetMapping("/company")
    public String company(ModelMap modelMap) {
        List<Company> companyAll = companyRepository.findAll();
        modelMap.addAttribute("companys",companyAll);
        return "company";
    }
    @GetMapping("/addCompany")
    public String addCompany(){
        return "addCompany";
    }
    @PostMapping("/addCompany")
    public String addCompanyPost(@RequestParam("name") String name,
                                 @RequestParam("size") int size,
                                 @RequestParam("address") String address) {
        Company company = Company.builder()
                .name(name)
                .size(size)
                .address(address)
                .build();
        companyRepository.save(company);
        return "redirect:/company";

    }
    @GetMapping("/company/{id}")
    public String deleteCompany(@PathVariable("id") int id) {
            companyRepository.deleteById(id);
            return "redirect:/company";


    }



}
