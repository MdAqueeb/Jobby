package com.example.jobby.DTO;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobFilter {
    private List<String> employeType;
    private String search;
    private Integer min_salary;

    @PrePersist
    void assignVlaues(){
        search = "";
        min_salary = 0;
        employeType = new ArrayList<>();
    }
}
