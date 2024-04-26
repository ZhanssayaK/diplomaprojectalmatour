package com.example.diploma.project.almatour.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MyAccomodationFunctionDTO {
    private Long id;
    private String description;
    private String name;
    private MultipartFile[] photos;
    private double price;
}
