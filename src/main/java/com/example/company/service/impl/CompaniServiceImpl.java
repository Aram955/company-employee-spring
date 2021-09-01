package com.example.company.service.impl;

import com.example.company.model.Company;
import com.example.company.repository.CompanyRepository;
import com.example.company.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompaniServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    @Override
    public List<Company> findAllCompanys() {
        return companyRepository.findAll();
    }

    @Override
    public void addCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public void deleteById(int id) {
        companyRepository.deleteById(id);
    }

    @Override
    public Company findCompanyById(int companyId){

        return companyRepository.getById(companyId);
    }
    @Override
    public Company getById(int id){

        return companyRepository.getById(id);
    }




}
