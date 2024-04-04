package com.example.diploma.project.almatour.mapper;

import com.example.diploma.project.almatour.dto.CreditCardDetailsDTO;
import com.example.diploma.project.almatour.model.CreditCardDetails;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CreditCardDetailsMapper {

    CreditCardDetails toEntity(CreditCardDetailsDTO creditCardDetailsDTO);

    CreditCardDetailsDTO toDTO(CreditCardDetails creditCardDetails);

    List<CreditCardDetailsDTO> toDTOList(List<CreditCardDetails> creditCardDetails);

}
