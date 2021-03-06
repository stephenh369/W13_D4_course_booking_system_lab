package com.codeclan.example.course_booking_system.controllers;

import com.codeclan.example.course_booking_system.models.Course;
import com.codeclan.example.course_booking_system.models.Customer;
import com.codeclan.example.course_booking_system.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value = "/courses")
    public ResponseEntity<List<Course>> getAllCourses(@RequestParam(name = "rating", required = false) Integer rating,
                                                      @RequestParam(name = "customer", required = false) String name) {
        if (rating != null) {
            return new ResponseEntity<>(courseRepository.findByRating(rating), HttpStatus.OK);
        }
        if (name != null) {
            return new ResponseEntity<>(courseRepository.findByBookingsCustomerName(name), HttpStatus.OK);
        }
        return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/courses/{id}")
    public ResponseEntity<List<Course>> getCoursesById(@PathVariable Long id) {
        return new ResponseEntity(courseRepository.findById(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/courses/{id}")
    public ResponseEntity<List<Course>> deleteCourse(@PathVariable Long id) {
        courseRepository.deleteById(id);
        return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping(value = "/courses")
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        courseRepository.save(course);
        return new ResponseEntity<>(course, HttpStatus.CREATED);
    }

    @PutMapping(value = "/courses/{id}")
    public ResponseEntity<Course> updateCourse(@RequestBody Course course, @PathVariable long id) {
        courseRepository.save(course);
        return new ResponseEntity<>(course, HttpStatus.CREATED);
    }
}
