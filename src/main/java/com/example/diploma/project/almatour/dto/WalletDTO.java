package com.example.diploma.project.almatour.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WalletDTO {
    private Long id;
    private Long userId;
    private int balance;
}
