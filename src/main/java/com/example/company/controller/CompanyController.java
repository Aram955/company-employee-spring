package com.example.company.controller;

import com.example.company.model.Company;
import com.example.company.service.CompanyService;
import com.example.company.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CompanyController {

   private final CompanyService companyService;
   private final EmployeeService employeeService;

    @GetMapping("/company")
    public String company(ModelMap modelMap) {
        List<Company> companyAll = companyService.findAllCompanys();
        modelMap.addAttribute("companys",companyAll);
        return "company";
    }
    @GetMapping("/addCompany")
    public String addCompany(){
        return "addCompany";
    }

    @PostMapping("/addCompany")
    public String addCompanyPost(@ModelAttribute Company company){
     companyService.addCompany(company);
        return "redirect:/company";

    }
    @GetMapping("/company/{id}")
    public String deleteCompany(@PathVariable("id") int id) {
                employeeService.deleteAllByCompanyId(id);
                companyService.deleteById(id);
                return "redirect:/company";


    }



}
