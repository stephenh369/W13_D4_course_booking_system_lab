package com.codeclan.example.course_booking_system.controllers;

import com.codeclan.example.course_booking_system.models.Booking;
import com.codeclan.example.course_booking_system.models.Customer;
import com.codeclan.example.course_booking_system.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

    @GetMapping(value = "/bookings")
    public ResponseEntity<List<Booking>> getAllBookings() {
        return new ResponseEntity<>(bookingRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/bookings/{id}")
    public ResponseEntity<List<Booking>> getBookingsById(@PathVariable Long id) {
        return new ResponseEntity(bookingRepository.findById(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/bookings/{id}")
    public ResponseEntity<List<Booking>> deleteBooking(@PathVariable Long id) {
        bookingRepository.deleteById(id);
        return new ResponseEntity<>(bookingRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping(value = "/bookings")
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
        bookingRepository.save(booking);
        return new ResponseEntity<>(booking, HttpStatus.CREATED);
    }
}
