package com.codeclan.example.course_booking_system;

import com.codeclan.example.course_booking_system.models.Booking;
import com.codeclan.example.course_booking_system.models.Course;
import com.codeclan.example.course_booking_system.models.Customer;
import com.codeclan.example.course_booking_system.repositories.BookingRepository;
import com.codeclan.example.course_booking_system.repositories.CourseRepository;
import com.codeclan.example.course_booking_system.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CourseBookingSystemApplicationTests {

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	BookingRepository bookingRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void canFindCourseByRating() {
		List<Course> found = courseRepository.findByRating(4);
		assertEquals(1, found.size());
	}

	@Test
	void canFindCustomersByCourse() {
		List<Customer> found = customerRepository.findByBookingsCourseName("Intro to Python");
		assertEquals(1, found.size());
	}

	@Test
	void canFindByCustomerName() {
		List<Course> found = courseRepository.findByBookingsCustomerName("Stephen Herd");
		assertEquals(1, found.size());
	}

	@Test
	void canFindBookingsByDate() {
		List<Booking> found = bookingRepository.findByDate("20-10-20");
		assertEquals(1, found.size());
	}

}
