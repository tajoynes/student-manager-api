package com.edu.api.manager.services;

import com.edu.api.manager.exception.ResourceNotFoundException;
import com.edu.api.manager.models.Student;

import java.util.List;

public interface StudentService {
    Student createStudent(Student student);

    List<Student> getStudents();

    Student updateStudent(Long studentId, Student student) throws ResourceNotFoundException;

    void deleteStudent(Long studentId) throws ResourceNotFoundException;

    List<Student> findStudentsByLastName(String lastName);

    Student findStudentByStudentId(Long studentId);
}
