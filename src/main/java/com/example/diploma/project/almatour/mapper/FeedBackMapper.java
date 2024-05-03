package com.example.diploma.project.almatour.mapper;

import com.example.diploma.project.almatour.dto.FeedBackDTO;
import com.example.diploma.project.almatour.model.FeedBack;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FeedBackMapper {

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "accommodation.id", target = "accommodationId")
    FeedBackDTO toDto(FeedBack feedBack);

    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "accommodationId", target = "accommodation.id")
    FeedBack toEntity(FeedBackDTO feedBackDTO);

    List<FeedBackDTO> toDtoList(List<FeedBack> feedBacks);
}
