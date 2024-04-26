package com.example.diploma.project.almatour.mapper;

import com.example.diploma.project.almatour.dto.FeedBackDTO;
import com.example.diploma.project.almatour.dto.MyAccomodationFunctionDTO;
import com.example.diploma.project.almatour.model.Accommodation;
import com.example.diploma.project.almatour.model.FeedBack;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MyAccomodationFunctionMapper {
    MyAccomodationFunctionDTO toDto(Accommodation accommodation);
}
