package com.example.diploma.project.almatour.mapper;

import com.example.diploma.project.almatour.dto.BookingDTO;
import com.example.diploma.project.almatour.model.Booking;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookingMapper {
    BookingMapper INSTANCE = Mappers.getMapper(BookingMapper.class);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "accommodation.id", target = "accommodationId")
    BookingDTO toDto(Booking booking);

    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "accommodationId", target = "accommodation.id")
    Booking toEntity(BookingDTO bookingDTO);

    List<BookingDTO> toDtoList(List<Booking> bookings);
}
