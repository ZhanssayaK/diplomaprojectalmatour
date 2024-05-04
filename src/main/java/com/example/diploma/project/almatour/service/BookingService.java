package com.example.diploma.project.almatour.service;

import com.example.diploma.project.almatour.dto.AccommodationDTO;
import com.example.diploma.project.almatour.dto.AccomodationUserDTO;
import com.example.diploma.project.almatour.dto.BookingDTO;
import com.example.diploma.project.almatour.dto.UserDTO;
import com.example.diploma.project.almatour.exception.AccommmodationExistException;
import com.example.diploma.project.almatour.mapper.AccomodationUserMapper;
import com.example.diploma.project.almatour.mapper.BookingMapper;
import com.example.diploma.project.almatour.mapper.UserMapper;
import com.example.diploma.project.almatour.model.Accommodation;
import com.example.diploma.project.almatour.model.Booking;
import com.example.diploma.project.almatour.model.User;
import com.example.diploma.project.almatour.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;
    private final AccomodationUserMapper userMapper;

    public BookingDTO createBooking(BookingDTO bookingDTO) {
        return bookingMapper.toDto(bookingRepository.save(bookingMapper.toEntity(bookingDTO)));
    }

    public List<BookingDTO> getBookings(){
        return bookingMapper.toDtoList(bookingRepository.findAll());
    }

    public List<BookingDTO> getBookingByUserId(Long userId){
        return bookingMapper.toDtoList(bookingRepository.findByUserId(userId));
    }

    public List<AccomodationUserDTO> getUsersByAccommodation(Long accommodationId) {
        List<Booking> bookings = bookingRepository.findByAccommodationId(accommodationId);
        List<AccomodationUserDTO> userDTOs = new ArrayList<>();

        for (Booking booking : bookings) {
            AccomodationUserDTO userDTO = userMapper.toDto(booking.getUser());
            userDTOs.add(userDTO);
        }

        return userDTOs;
    }
}
