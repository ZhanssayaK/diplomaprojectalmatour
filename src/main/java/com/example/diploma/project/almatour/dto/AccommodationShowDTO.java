package com.example.diploma.project.almatour.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Builder
public class AccommodationShowDTO {
    private Long id;
    private String name;
    private Timestamp startTime;
    private String location;
    private double price;
    private String description;
    private String path;
    private boolean status;
    private UserDTO user;
    private CityDTO city;
}
