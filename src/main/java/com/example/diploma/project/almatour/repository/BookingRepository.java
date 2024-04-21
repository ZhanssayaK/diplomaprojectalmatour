package com.example.diploma.project.almatour.repository;

import com.example.diploma.project.almatour.model.Booking;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {

}
