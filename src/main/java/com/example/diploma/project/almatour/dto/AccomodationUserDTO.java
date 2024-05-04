package com.example.diploma.project.almatour.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccomodationUserDTO {
    private Long id;
    private String email;
    private String fullName;
    private String phoneNumber;
    private boolean isBlocked;
    private Long cityId;
    private String avatarUrl;
}
