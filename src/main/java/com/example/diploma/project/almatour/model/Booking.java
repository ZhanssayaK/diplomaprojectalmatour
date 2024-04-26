package com.example.diploma.project.almatour.model;

import com.example.diploma.project.almatour.enums.BookingStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table
@Getter
@Setter
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Accommodation accommodation;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;

    @Column
    private LocalDateTime bookingTime;
}
