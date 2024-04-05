package com.example.jparelationii.Repository;



import com.example.jparelationii.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
    Teacher findTeacherById(Integer id);

  @Query("select teacher from Teacher teacher where teacher.id=?1")
    List<Teacher> getTeacherById(Integer id);
}
