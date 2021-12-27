package com.example.autoservice.repository;

import com.example.autoservice.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository <Company, Integer> {

}
