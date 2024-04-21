package com.example.diploma.project.almatour.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FeedBackDTO {
    private Long id;

    private String feedBack;

    private LocalDateTime addedTime;

    private Long accommodationId;

}
