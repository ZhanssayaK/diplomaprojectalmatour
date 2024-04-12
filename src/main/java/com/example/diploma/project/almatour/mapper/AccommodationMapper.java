package com.example.diploma.project.almatour.mapper;

import com.example.diploma.project.almatour.dto.AccommodationDTO;
import com.example.diploma.project.almatour.dto.AccommodationDetailDTO;
import com.example.diploma.project.almatour.model.Accommodation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccommodationMapper {

    AccommodationMapper INSTANCE = Mappers.getMapper(AccommodationMapper.class);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "city.id", target = "cityId")
    AccommodationDTO toDto(Accommodation accommodation);

    @Mapping(source = "categories", target = "category")
    AccommodationDetailDTO toDtoDetail(Accommodation accommodation);

    List<AccommodationDTO> toDtoList(List<Accommodation> accommodations);

    @Mapping(target = "user.id", source = "accommodationDTO.userId")
    @Mapping(target = "city.id", source = "accommodationDTO.cityId")
    @Mapping(target = "categories.id", source = "accommodationDTO.categoryId")
    Accommodation toEntity(AccommodationDTO accommodationDTO);


    @Mapping(target = "categories", source = "accommodationDTO.category")
    Accommodation toEntityDetail(AccommodationDetailDTO accommodationDTO);
}