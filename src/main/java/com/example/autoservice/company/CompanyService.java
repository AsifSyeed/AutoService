package com.example.autoservice.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<Company> getCompanies() {
        return companyRepository.findAll();
    }

    public void addNewCompany(Company company) {
        Optional<Company> optionalCompany =  companyRepository.findCompanyById(company.getId());
        if (optionalCompany.isPresent()) {
            throw new IllegalStateException("Company Already Exists.");
        }
        companyRepository.save(company);
    }
}
