package com.example.jparelationii.Service;




import com.example.jparelationii.Api.ApiException;
import com.example.jparelationii.Model.Course;
import com.example.jparelationii.Model.Teacher;
import com.example.jparelationii.Repository.CourseRepository;
import com.example.jparelationii.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;
    public List<Course> getCourse() {
        return courseRepository.findAll();
    }

    public void addCourse( Integer teacherId, Course course) {
        Teacher teacher = teacherRepository.findTeacherById(teacherId);
        if (teacher == null) {
            throw new ApiException("teacher id not found");
        }
        course.setTeacher(teacher);
        courseRepository.save(course);
    }
    public void updateCourse(Integer id, Course course) {
        Course course1 = courseRepository.findCourseById(id);
        if (course1 == null) {
            throw new ApiException("course id not found");
        }
        course1.setName(course.getName());
        courseRepository.save(course1);

    }

    public void deleteCourse(Integer id) {
        Course course = courseRepository.findCourseById(id);
        if (course == null) {
            throw new ApiException("course id not found");
        }
        courseRepository.delete(course);
    }

    public String getTeacherName(Integer cid) {
        Course course = courseRepository.findCourseById(cid);
        if (course == null) {
            throw new ApiException("course id not found");
        }

        return course.getTeacher().getName();
    }
}

