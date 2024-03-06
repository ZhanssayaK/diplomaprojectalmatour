package com.example.diploma.project.almatour.service;

import com.example.diploma.project.almatour.dto.CreditCardDetailsDTO;
import com.example.diploma.project.almatour.mapper.CreditCardDetailsMapper;
import com.example.diploma.project.almatour.model.Accommodation;
import com.example.diploma.project.almatour.model.CreditCardDetails;

import com.example.diploma.project.almatour.repository.CreditCardDetailsRepository;
import com.example.diploma.project.almatour.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreditCardDetailsService {
    private final CreditCardDetailsRepository creditCardDetailsRepository;
    private final CreditCardDetailsMapper creditCardDetailsMapper;
    private final UserRepository userRepository;

    public List<CreditCardDetailsDTO> creditCardDetails() {
        return creditCardDetailsMapper.toDTOList(creditCardDetailsRepository.findAll());
    }

    public CreditCardDetailsDTO creditCardDetailsById(Long id) {
        return creditCardDetailsMapper.toDTO(creditCardDetailsRepository.findById(id).orElse(null));
    }

    public void deleteCreditCardDetailsById(Long id) {
        creditCardDetailsRepository.deleteById(id);
    }

    public CreditCardDetailsDTO addCreditCardDetails(Long id, CreditCardDetailsDTO creditCardDetailsDTO) {
        CreditCardDetails creditCardDetails1 = creditCardDetailsMapper.toEntity(creditCardDetailsDTO);
        return creditCardDetailsMapper.toDTO(creditCardDetailsRepository.save(creditCardDetails1));
    }
}
