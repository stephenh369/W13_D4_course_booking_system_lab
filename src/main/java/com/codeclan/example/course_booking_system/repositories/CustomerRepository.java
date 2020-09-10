package com.codeclan.example.course_booking_system.repositories;

import com.codeclan.example.course_booking_system.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByBookingsCourseName(String name);
}
