package com.example.autoservice.company;

import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.List;

@Service
public class CompanyService {

    public List<Company> getCompanies() {
        return List.of(
                new Company(
                        "Ferrari",
                        "Italy",
                        Year.of(1947)
                )
        );
    }
}
