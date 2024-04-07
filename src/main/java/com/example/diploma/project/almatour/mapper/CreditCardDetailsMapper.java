package com.example.diploma.project.almatour.mapper;

import com.example.diploma.project.almatour.dto.CreditCardDetailsDTO;
import com.example.diploma.project.almatour.model.CreditCardDetails;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CreditCardDetailsMapper {

    CreditCardDetailsMapper INSTANCE = Mappers.getMapper(CreditCardDetailsMapper.class);

    CreditCardDetails toEntity(CreditCardDetailsDTO creditCardDetailsDTO);

    CreditCardDetailsDTO toDTO(CreditCardDetails creditCardDetails);

    List<CreditCardDetailsDTO> toDTOList(List<CreditCardDetails> creditCardDetailsList);

    List<CreditCardDetails> toEntityList(List<CreditCardDetailsDTO> creditCardDetailsDTOList);
}
