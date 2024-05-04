package com.example.diploma.project.almatour.api;

import com.example.diploma.project.almatour.dto.AccomodationUserDTO;
import com.example.diploma.project.almatour.dto.BookingDTO;
import com.example.diploma.project.almatour.dto.UserDTO;
import com.example.diploma.project.almatour.model.User;
import com.example.diploma.project.almatour.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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

    @GetMapping(value = "/findByUserId/{currentUserId}")
    public List<BookingDTO> getBookingByUserId(@PathVariable(value = "currentUserId") Long currentUserId){
        return bookingService.getBookingByUserId(currentUserId);
    }

    @GetMapping("/users-by-accommodation/{id}")
    public ResponseEntity<List<AccomodationUserDTO>> getUsersByAccommodation(@PathVariable Long id) {
        List<AccomodationUserDTO> users = bookingService.getUsersByAccommodation(id);
        return ResponseEntity.ok(users);
    }
}
