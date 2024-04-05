package com.example.jparelationii.Controller;


import com.example.jparelationii.Api.ApiResponse;
import com.example.jparelationii.Model.Course;
import com.example.jparelationii.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/get")
    public ResponseEntity getCourse(){
        return ResponseEntity.status(200).body(courseService.getCourse());
    }

    @PostMapping("/add/{teacherId}")
    public ResponseEntity addCourse(@PathVariable Integer teacherId, @RequestBody @Valid Course course){
        courseService.addCourse( teacherId , course);
        return ResponseEntity.ok().body(new ApiResponse("Course added and assigned to teacher with id "+ teacherId));

    }
    @PutMapping("/Update/{id}")
    public ResponseEntity UpdateCourse(@PathVariable Integer id, @RequestBody @Valid Course course){
        courseService.updateCourse(id , course);
        return ResponseEntity.ok().body(new ApiResponse("Course Updated"));

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCourse(@PathVariable Integer id){
        courseService.deleteCourse(id);
        return ResponseEntity.ok().body(new ApiResponse("Course Deleted"));

    }
    @GetMapping("/get-teacher-name/{cId}")
    public ResponseEntity getTeacherName(@PathVariable Integer cId){
        return ResponseEntity.ok().body(new ApiResponse("Teacher name: "+courseService.getTeacherName(cId)));

    }
}
