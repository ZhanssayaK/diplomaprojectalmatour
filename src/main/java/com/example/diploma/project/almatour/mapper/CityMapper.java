package com.example.diploma.project.almatour.mapper;

import com.example.diploma.project.almatour.dto.CityDTO;
import com.example.diploma.project.almatour.dto.UserDTO;
import com.example.diploma.project.almatour.model.City;
import com.example.diploma.project.almatour.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CityMapper {
    CityMapper INSTANCE = Mappers.getMapper(CityMapper.class);

    CityDTO toDto(City city);
}
