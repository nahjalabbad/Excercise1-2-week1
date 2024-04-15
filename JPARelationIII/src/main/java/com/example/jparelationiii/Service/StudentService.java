package com.example.jparelationiii.Service;

import com.example.jparelationiii.Api.ApiException;
import com.example.jparelationiii.Model.Course;
import com.example.jparelationiii.Model.Student;
import com.example.jparelationiii.Repository.CourseRepository;
import com.example.jparelationiii.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public void addStudent(Student student){
        studentRepository.save(student);
    }

    public void updateStudent(Integer id, Student student){
        Student student1= studentRepository.findStudentById(id);
        if (student1==null){
            throw new ApiException("Id not found");
        }
        student1.setName(student.getName());
        student1.setMajor(student.getMajor());
        student1.setAge(student.getAge());

        studentRepository.save(student1);
    }

    public void deleteStudent(Integer id){
        Student student= studentRepository.findStudentById(id);
        if (student==null){
            throw new ApiException("Id not found");
        }
        studentRepository.delete(student);
    }

    public void assignStudentToCourse(Integer studentId, Integer courseId){
        Student student=studentRepository.findStudentById(studentId);
        Course course=courseRepository.findCourseById(courseId);

        if (student==null||course==null){
            throw new ApiException("cant assign");
        }

        student.getCourses().add(course);
        course.getStudents().add(student);

        courseRepository.save(course);
        studentRepository.save(student);
    }

    public void changeMajor(Integer studentId, String major){
        Student student=studentRepository.findStudentById(studentId);
        if (student==null){
            throw new ApiException("Id not found");
        }
           if (student.getMajor().equalsIgnoreCase(major)){
            throw new ApiException("the major entered is the same as the one in student major");
        }
        
        student.setMajor(major);
        student.getCourses().forEach(course -> course.getStudents().remove(student));
        student.getCourses().clear();
        studentRepository.save(student);
    }

}
