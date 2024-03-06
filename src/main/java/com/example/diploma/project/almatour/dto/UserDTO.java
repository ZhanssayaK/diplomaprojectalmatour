package com.example.diploma.project.almatour.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long id;
    private String email;
    private String fullName;
    private boolean isBlocked;
    private Long cityId;
}
