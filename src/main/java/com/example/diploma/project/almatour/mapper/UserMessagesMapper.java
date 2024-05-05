package com.example.diploma.project.almatour.mapper;

import com.example.diploma.project.almatour.dto.UserDTO;
import com.example.diploma.project.almatour.dto.UserMessagesDTO;
import com.example.diploma.project.almatour.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMessagesMapper {

    UserMessagesDTO toDto(User user);
    User toEntity(UserMessagesDTO userMessagesDTO);
    List<UserMessagesDTO> toDtoList(List<User> users);
}
