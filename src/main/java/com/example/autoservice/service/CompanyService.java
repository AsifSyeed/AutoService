package com.example.autoservice.service;

import com.example.autoservice.model.Company;
import com.example.autoservice.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
    @Autowired
    CompanyRepository companyRepository;
    public List<Company> getAllCompany() {
        return companyRepository.findAll();
    }
    public void addCompany(Company company) {
        companyRepository.save(company);
    }
    public void removeCompanyById(int id) {
        companyRepository.deleteById(id);
    }
    public Optional<Company> getCompanyById(int id) {
        return companyRepository.findById(id);
    }
}
