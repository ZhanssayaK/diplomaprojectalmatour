package com.example.diploma.project.almatour.dto;

import com.example.diploma.project.almatour.enums.BookingStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class BookingDTO {

    private Long userId;
    private Long accommodationId;
    private BookingStatus status;
    private LocalDateTime bookingTime;
}
