package com.example.jparelationiii.Service;

import com.example.jparelationiii.Api.ApiException;

import com.example.jparelationiii.Model.Teacher;
import com.example.jparelationiii.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public List<Teacher> getAllTeachers(){
        return teacherRepository.findAll();
    }

    public void addTeacher(Teacher teacher){
        teacherRepository.save(teacher);
    }

    public void updateTeacher(Integer id, Teacher teacher){
        Teacher teacher1= teacherRepository.findTeacherById(id);
        if (teacher1==null){
            throw new ApiException("Id not found");
        }
        teacher1.setName(teacher.getName());
        teacher1.setEmail(teacher.getEmail());
        teacher1.setAge(teacher.getAge());
        teacher1.setSalary(teacher1.getSalary());

        teacherRepository.save(teacher1);
    }

    public void deleteTeacher(Integer id){
        Teacher teacher= teacherRepository.findTeacherById(id);
        if (teacher==null){
            throw new ApiException("Id not found");
        }
        teacherRepository.delete(teacher);
    }

    public List<Teacher> getTeacherInfo(Integer id){
        List<Teacher> getTeachers = teacherRepository.getTeacherById(id);
        if (getTeachers.isEmpty()){
            throw new ApiException("No Teacher With This ID has been found");
        }
        return getTeachers;
    }


}
