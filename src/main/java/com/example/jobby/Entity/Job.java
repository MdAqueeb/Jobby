
package com.example.jobby.Entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long job_id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Employment_Type employment_type;

    @Column(nullable = false)
    private String job_description;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private Integer package_per_annum;

    private Integer rating;

    @Column(nullable = false)
    private String job_title;
    // skills relation : one to many

    @OneToMany(mappedBy = "job", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Skills> skills;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    @JsonBackReference
    private Company company;



    enum Employment_Type{
        full_time, 
        internship, 
        freelancer, 
        part_time
    }

    void assignValues(){
        employment_type = Employment_Type.full_time;
        skills = new ArrayList<>();
    }

}


