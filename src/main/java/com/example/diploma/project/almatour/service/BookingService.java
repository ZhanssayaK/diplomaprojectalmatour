package com.example.diploma.project.almatour.service;

import com.example.diploma.project.almatour.dto.AccommodationDTO;
import com.example.diploma.project.almatour.dto.BookingDTO;
import com.example.diploma.project.almatour.exception.AccommmodationExistException;
import com.example.diploma.project.almatour.mapper.BookingMapper;
import com.example.diploma.project.almatour.model.Accommodation;
import com.example.diploma.project.almatour.model.Booking;
import com.example.diploma.project.almatour.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;

    public BookingDTO createBooking(BookingDTO bookingDTO) {
        return bookingMapper.toDto(bookingRepository.save(bookingMapper.toEntity(bookingDTO)));
    }

    public List<BookingDTO> getBookings(){
        return bookingMapper.toDtoList(bookingRepository.findAll());
    }

    public List<BookingDTO> getBookingByUserId(Long userId){
        return bookingMapper.toDtoList(bookingRepository.findByUserId(userId));
    }
}
