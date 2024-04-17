package com.example.diploma.project.almatour.dto;

import com.example.diploma.project.almatour.model.Category;
import com.example.diploma.project.almatour.model.City;
import com.example.diploma.project.almatour.model.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@Builder
public class AccommodationDetailDTO {
    private Long id;
    private String description;
    private Category category;
    private String name;
    private Timestamp startTime;
    private Timestamp endTime;
    private String location;
    private double price;
    private City city;
    private User user;
    private boolean status;
    private String mainPhoto;
    private List<String> otherPhoto;
    private String comment;
}
