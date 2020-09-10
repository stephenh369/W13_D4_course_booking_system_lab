package com.codeclan.example.course_booking_system.components;

import com.codeclan.example.course_booking_system.models.Booking;
import com.codeclan.example.course_booking_system.models.Course;
import com.codeclan.example.course_booking_system.models.Customer;
import com.codeclan.example.course_booking_system.repositories.BookingRepository;
import com.codeclan.example.course_booking_system.repositories.CourseRepository;
import com.codeclan.example.course_booking_system.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CourseRepository courseRepository;

    public DataLoader() {
    }

    public void run(ApplicationArguments args) {
        Customer stephen = new Customer("Stephen Herd", "Bathgate", 25);
        customerRepository.save(stephen);

        Course pythonCourse = new Course("Intro to Python", "Edinburgh", 4);
        courseRepository.save(pythonCourse);

        Booking stephenPythonBooking = new Booking("10-10-20",pythonCourse, stephen);
        bookingRepository.save(stephenPythonBooking);



        Customer ronan = new Customer("Ronan Hughes", "Edinburgh", 27);
        customerRepository.save(ronan);

        Course rubyCourse = new Course("Advanced Ruby", "Glasgow", 3);
        courseRepository.save(rubyCourse);

        Booking ronanRubyBooking = new Booking("20-10-20",rubyCourse, ronan);
        bookingRepository.save(ronanRubyBooking);



        Customer helena = new Customer("Helena Kolberg", "Tallinn", 28);
        customerRepository.save(helena);

        Course mushroomCourse = new Course("Mushroom foraging 101", "Edinburgh", 5);
        courseRepository.save(mushroomCourse);

        Booking helenaMushroomBooking = new Booking("15-10-20",mushroomCourse, helena);
        bookingRepository.save(helenaMushroomBooking);
    }
}
