package com.example.diploma.project.almatour.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BookingDTO {

    private Long userId;
    private Long accommodationId;
}
