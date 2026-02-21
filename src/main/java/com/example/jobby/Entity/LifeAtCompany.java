package com.example.jobby.Entity;

import jakarta.persistence.*;

@Entity
public class LifeAtCompany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 2000)
    private String description;

    private String imageUrl;

}

