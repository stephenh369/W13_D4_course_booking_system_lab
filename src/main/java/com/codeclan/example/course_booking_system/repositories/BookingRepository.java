package com.codeclan.example.course_booking_system.repositories;

import com.codeclan.example.course_booking_system.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByDate(String date);
}
