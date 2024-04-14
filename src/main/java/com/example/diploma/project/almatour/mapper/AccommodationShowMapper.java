package com.example.diploma.project.almatour.mapper;

import com.example.diploma.project.almatour.dto.AccommodationShowDTO;
import com.example.diploma.project.almatour.model.Accommodation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",uses = {UserMapper.class, CityMapper.class})
public interface AccommodationShowMapper {
    AccommodationShowMapper INSTANCE = Mappers.getMapper(AccommodationShowMapper.class);
    @Mapping(target = "path", ignore = true)

    AccommodationShowDTO toDto(Accommodation accommodation);

    List<AccommodationShowDTO> toDtoList(List<Accommodation> accommodations);

}
