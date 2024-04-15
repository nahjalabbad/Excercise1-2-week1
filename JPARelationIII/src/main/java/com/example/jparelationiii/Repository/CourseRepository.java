package com.example.jparelationiii.Repository;


import com.example.jparelationiii.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Integer> {
    Course findCourseById(Integer id);
}
