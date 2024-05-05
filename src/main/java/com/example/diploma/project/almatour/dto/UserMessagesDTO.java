package com.example.diploma.project.almatour.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserMessagesDTO {
    private Long id;
    private String email;
    private String fullName;
    private String avatarUrl;
}
