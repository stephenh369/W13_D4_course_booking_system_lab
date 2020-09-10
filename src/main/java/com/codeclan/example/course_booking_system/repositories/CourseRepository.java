package com.codeclan.example.course_booking_system.repositories;

import com.codeclan.example.course_booking_system.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
