package com.example.diploma.project.almatour.dto;
import lombok.*;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccommodationDTO {
    private Long id;
    private String name;
//    private String description;
    private double price;
    private String location;
//    private Timestamp startTime;
//    private Timestamp endTime;
    private Long userId;
    private Long cityId;
    private boolean isStatus;
//    private List<Long> categoryIds;
}
