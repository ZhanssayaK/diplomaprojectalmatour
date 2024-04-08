package com.example.diploma.project.almatour.mapper;

import com.example.diploma.project.almatour.dto.AccommodationShowDTO;
import com.example.diploma.project.almatour.model.Accommodation;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccommodationShowMapper {
    AccommodationShowMapper INSTANCE = Mappers.getMapper(AccommodationShowMapper.class);

    AccommodationShowDTO toDto(Accommodation accommodation);

    List<AccommodationShowDTO> toDtoList(List<Accommodation> accommodations);

}
