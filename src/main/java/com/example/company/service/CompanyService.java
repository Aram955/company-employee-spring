package com.example.company.service;

import com.example.company.model.Company;

import java.util.List;

public interface CompanyService {

    List<Company> findAllCompanys();

    void addCompany(Company company);

    void deleteById(int id);

    Company findCompanyById(int companyId);

    Company getById(int id);


}
