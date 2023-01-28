package com.edu.api.manager.repository;

import com.edu.api.manager.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
   public List<Student> findStudentsByLastName(String lastName);
   Student findStudentByStudentId(Long studentId);
}
