package com.example.diploma.project.almatour.service;

import com.example.diploma.project.almatour.dto.AccommodationDTO;
import com.example.diploma.project.almatour.dto.CreditCardDetailsDTO;
import com.example.diploma.project.almatour.mapper.CreditCardDetailsMapper;
import com.example.diploma.project.almatour.model.Accommodation;
import com.example.diploma.project.almatour.model.CreditCardDetails;

import com.example.diploma.project.almatour.model.User;
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
    private final AuthenticationService authenticationService;
    private final WalletService walletService;

    public List<CreditCardDetailsDTO> creditCardDetails() {
        return creditCardDetailsMapper.toDTOList(creditCardDetailsRepository.findAll());
    }

    public CreditCardDetailsDTO creditCardDetailsById(Long id) {
        return creditCardDetailsMapper.toDTO(creditCardDetailsRepository.findById(id).orElse(null));
    }

    public CreditCardDetailsDTO creditCardDetailsByUserId(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            return creditCardDetailsMapper.toDTO(user.getCreditCardDetails());
        }
        return null;
    }

    public void deleteCreditCardDetailsById(Long id) {
        creditCardDetailsRepository.deleteById(id);
    }

    public CreditCardDetailsDTO addCreditCardDetails(CreditCardDetailsDTO dto) {
        CreditCardDetails details = null;
        if (dto.getUserId() != null) {
            if (userRepository.findById(dto.getUserId()).isPresent()) {
                User user = userRepository.findById(dto.getUserId()).get();
                if (user.getCreditCardDetails() != null) {
                    details = user.getCreditCardDetails();
                } else {
                    details = new CreditCardDetails();
                }
                details.setCardNumber(dto.getCardNumber());
                details.setCvv(dto.getCvv());
                details.setFullName(dto.getFullName());
                details.setExpirationDate(dto.getExpirationDate());
                CreditCardDetails cr = creditCardDetailsRepository.save(details);

                user.setCreditCardDetails(details);
                userRepository.save(user);
                return creditCardDetailsMapper.toDTO(cr);
            }
        }
        return null;
    }
}
