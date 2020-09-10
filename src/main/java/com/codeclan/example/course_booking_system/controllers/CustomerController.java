package com.codeclan.example.course_booking_system.controllers;

import com.codeclan.example.course_booking_system.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class
CustomerController {

    @Autowired
    CustomerRepository customerRepository;
}
