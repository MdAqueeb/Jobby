package com.example.jobby.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jobby.Entity.Skills;

public interface SkillRepo extends JpaRepository<Skills, Long>{
    
}
