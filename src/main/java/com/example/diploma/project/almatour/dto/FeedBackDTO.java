package com.example.diploma.project.almatour.dto;

import com.example.diploma.project.almatour.model.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class FeedBackDTO {

    private Long id;
    private String text;
    private LocalDateTime addedTime;
    private Long accommodationId;
    private Long userId;
}
