package com.example.diploma.project.almatour.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WithdrawAndBookDTO {
    private DepositToWalletDTO depositDto;
    private Long accommodationId;
    private Long userId;
}
