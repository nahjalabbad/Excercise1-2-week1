package com.example.jparelationiii.Controller;

import com.example.jparelationiii.Api.ApiResponse;
import com.example.jparelationiii.Model.Student;
import com.example.jparelationiii.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/get")
    public ResponseEntity getAllStudents(){
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody @Valid Student student){
        studentService.addStudent(student);
        return ResponseEntity.status(200).body(new ApiResponse("Student added"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@PathVariable Integer id, @RequestBody @Valid Student student){
        studentService.updateStudent(id,student);
        return ResponseEntity.ok().body(new ApiResponse("Student updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable Integer id){
        studentService.deleteStudent(id);
        return ResponseEntity.ok().body(new ApiResponse("Student deleted"));
    }


    @PutMapping("/assign-student-course/{studentId}/{courseId}")
    public ResponseEntity assignStudentToCourse(@PathVariable Integer studentId, @PathVariable Integer courseId){
        studentService.assignStudentToCourse(studentId,courseId);
        return ResponseEntity.ok(new ApiResponse("student assigned to course"));
    }

    @PutMapping("/change-major/{id}/{major}")
    public ResponseEntity updateStudent(@PathVariable Integer id, @PathVariable String major){
        studentService.changeMajor(id,major);
        return ResponseEntity.ok().body(new ApiResponse("Student major has been changed"));
    }


}
