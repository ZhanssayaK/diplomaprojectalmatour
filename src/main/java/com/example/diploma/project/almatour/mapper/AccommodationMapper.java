package com.example.diploma.project.almatour.mapper;

import com.example.diploma.project.almatour.dto.AccommodationDTO;
import com.example.diploma.project.almatour.model.Accommodation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccommodationMapper {

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "city.id", target = "cityId")
    @Mapping(source = "status", target = "isStatus")
    AccommodationDTO toDto(Accommodation accommodation);

    List<AccommodationDTO> toDtoList(List<Accommodation> accommodations);

    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "cityId", target = "city.id")
    Accommodation toEntity(AccommodationDTO accommodationDTO);
}