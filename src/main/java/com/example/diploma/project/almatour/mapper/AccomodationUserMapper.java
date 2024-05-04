package com.example.diploma.project.almatour.mapper;

import com.example.diploma.project.almatour.dto.AccomodationUserDTO;
import com.example.diploma.project.almatour.dto.UserDTO;
import com.example.diploma.project.almatour.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccomodationUserMapper {

    @Mapping(source = "city.id", target = "cityId")
    @Mapping(source = "blocked",target = "isBlocked")
    AccomodationUserDTO toDto(User user);

    User toEntity(AccomodationUserDTO accomodationUserDTO);

    List<AccomodationUserDTO> toDtoList(List<User> users);
}
