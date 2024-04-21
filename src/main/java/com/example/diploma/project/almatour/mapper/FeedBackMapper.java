package com.example.diploma.project.almatour.mapper;

import com.example.diploma.project.almatour.dto.FeedBackDTO;
import com.example.diploma.project.almatour.model.FeedBack;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FeedBackMapper {
    FeedBackMapper INSTANCE = Mappers.getMapper(FeedBackMapper.class);

    @Mapping(target = "accommodationId", source = "accommodation.id")
    FeedBackDTO toDto(FeedBack feedBack);

    @Mapping(target = "accommodation.id", source = "accommodationId")
    FeedBack toEntity(FeedBackDTO feedBackDTO);

    List<FeedBackDTO> toDtoList(List<FeedBack> feedBacks);

}
