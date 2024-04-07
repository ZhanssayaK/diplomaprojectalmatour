package com.example.diploma.project.almatour.api;

import com.example.diploma.project.almatour.dto.CreditCardDetailsDTO;
import com.example.diploma.project.almatour.service.CreditCardDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/credit-card-details")
public class CreditCardDetailsController {

    private final CreditCardDetailsService creditCardDetailsService;

    @GetMapping
    public List<CreditCardDetailsDTO> getCreditCardDetails() {
        return creditCardDetailsService.creditCardDetails();
    }

    @GetMapping(value = "/{id}")
    public CreditCardDetailsDTO getCreditCardDetailsById(@PathVariable Long id) {
        return creditCardDetailsService.creditCardDetailsById(id);
    }

    @GetMapping(value = "/getByUserId/{id}")
    public CreditCardDetailsDTO getCreditCardDetailsByUserId(@PathVariable Long id) {
        return creditCardDetailsService.creditCardDetailsByUserId(id);
    }

    @PostMapping
    public CreditCardDetailsDTO addCreditCardDetails(@RequestBody CreditCardDetailsDTO creditCardDetailsDTO){
        return creditCardDetailsService.addCreditCardDetails(creditCardDetailsDTO);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCreditCardDetailsById(@PathVariable Long id) {
        creditCardDetailsService.deleteCreditCardDetailsById(id);
    }
}
