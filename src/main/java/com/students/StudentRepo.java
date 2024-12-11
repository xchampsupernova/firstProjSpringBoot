package com.students;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface StudentRepo extends JpaRepository<Student,Integer> {
    @Query("SELECT s FROM Student s WHERE s.subject=?1")
    List<Student> findStudentsByCourseSubject(String course);

    @Query("SELECT s FROM Student s WHERE s.isGrad=true")
    List<Student> findStudentsByDegree();
}
