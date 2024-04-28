package com.example.diploma.project.almatour.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;

@Getter
@Setter
@Builder
public class AccommodationDTO {
    private Long id;
    private String description;
    private Long categoryId;
    private String name;
    private Timestamp startTime;
    private Timestamp endTime;
    private String location;
    private double price;
    private Long cityId;
    private Long userId;
    private boolean status;
    private MultipartFile[] photos;
    private String mainPhoto;
}