package com.example.diploma.project.almatour.mapper;

import com.example.diploma.project.almatour.dto.UserDTO;
import com.example.diploma.project.almatour.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

//    @Mapping(target = "user.avatarUrl", ignore = true)
//    @Mapping(target = "user.password", ignore = true)
    @Mapping(source = "city.id", target = "cityId")
    @Mapping(source = "blocked",target = "isBlocked")
    UserDTO toDto(User user);

//    @Mapping(source = "cityId", target = "city.id")
//    @Mapping(source = "creditCardDetailsId", target = "creditCardDetails.id")
    User toEntity(UserDTO userDTO);

    List<UserDTO> toDtoList(List<User> users);
}
