package com.example.jobby.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jobby.Entity.Job;

public interface JobRepo extends JpaRepository<Job, Long> {
    
}
