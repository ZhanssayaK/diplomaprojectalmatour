package com.example.diploma.project.almatour.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreditCardDetailsDTO {
    private Long id;

    private String fullName;

    private String cardNumber;

    private String expirationDate;

    private String cvv;

}
