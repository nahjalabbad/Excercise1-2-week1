package com.example.jparelationii.Controller;



import com.example.jparelationii.Api.ApiResponse;
import com.example.jparelationii.Model.Teacher;
import com.example.jparelationii.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/teacher")
public class TeacherController {
    private final TeacherService teacherService;

    @GetMapping("/get")
    public ResponseEntity getAllTeachers(){
        return ResponseEntity.ok(teacherService.getAllTeachers());
    }

    @PostMapping("/add")
    public ResponseEntity addTeacher(@RequestBody @Valid Teacher customer){
        teacherService.addTeacher(customer);
        return ResponseEntity.status(200).body(new ApiResponse("teacher added"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@PathVariable Integer id, @RequestBody @Valid Teacher customer){
        teacherService.updateTeacher(id,customer);
    return ResponseEntity.ok().body(new ApiResponse("teacher updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id){
        teacherService.deleteTeacher(id);
        return ResponseEntity.ok().body(new ApiResponse("teacher deleted"));
    }

    @GetMapping("/get-teacher/{id}")
    public ResponseEntity getTeacherInfo(@PathVariable Integer id){
        return ResponseEntity.ok().body(teacherService.getTeacherInfo(id));
    }



}
