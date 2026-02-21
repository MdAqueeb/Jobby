package com.example.jobby.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jobby.Entity.User;

public interface UserRepo extends JpaRepository<User, Long>{
    
}
