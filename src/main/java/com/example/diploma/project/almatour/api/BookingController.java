package com.example.diploma.project.almatour.api;

import com.example.diploma.project.almatour.dto.BookingDTO;
import com.example.diploma.project.almatour.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/bookings")
public class BookingController {

    private final BookingService bookingService;

    @PostMapping()
    public BookingDTO createBooking(@RequestBody BookingDTO bookingDTO) {
        return bookingService.createBooking(bookingDTO);
    }

    @GetMapping
    public List<BookingDTO> getBookings(){
        return bookingService.getBookings();
    }
}
