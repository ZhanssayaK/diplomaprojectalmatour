package com.example.diploma.project.almatour.mapper;

import com.example.diploma.project.almatour.dto.CreditCardDetailsDTO;
import com.example.diploma.project.almatour.model.CreditCardDetails;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CreditCardDetailsMapper {

    @Mapping(source = "userId", target = "user.id")
    CreditCardDetails toEntity(CreditCardDetailsDTO creditCardDetailsDTO);
    @Mapping(source = "user.id", target = "userId")
    CreditCardDetailsDTO toDTO(CreditCardDetails creditCardDetails);

    List<CreditCardDetailsDTO> toDTOList(List<CreditCardDetails> creditCardDetails);

}
