package com.example.jobby.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jobby.Entity.Company;

public interface CompanyRepo extends JpaRepository<Company, Long> {
    
}
