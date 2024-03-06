package com.example.diploma.project.almatour.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Getter
@Setter
public class Accommodation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "description", columnDefinition="TEXT")
    private String description;

    private double price;
    private String location;
    private Timestamp startTime;
    private Timestamp endTime;
    private boolean isStatus;

    @ManyToOne
    private User user;

    @ManyToOne
    private City city;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Category> categories;
}