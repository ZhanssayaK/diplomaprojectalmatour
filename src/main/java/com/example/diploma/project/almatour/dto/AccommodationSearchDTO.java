package com.example.diploma.project.almatour.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
@Getter
@Setter
public class AccommodationSearchDTO {
    private Long id;
    private String name;
    private String category;
    private String city;
    private Timestamp fromDate;
    private Timestamp toDate;
    private Integer minPrice;
    private Integer maxPrice;
}
