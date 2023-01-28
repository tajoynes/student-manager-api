package com.edu.api.manager.services;

import com.edu.api.manager.models.Student;
import com.edu.api.manager.repository.StudentRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StudentServiceTest {
    @Autowired
    private StudentService studentService;

    @MockBean
    private StudentRepository studentRepository;

    @BeforeEach
    void setUp() {
        Student student = Student.builder().studentId(1L).firstName("Steven").lastName("Smith").build();
        Mockito.when(studentRepository.findStudentByStudentId(1L)).thenReturn(student);
    }
    @Test
    @DisplayName("Get Student based on Valid ID")
    public void whenValidStudentID_thenStudentShouldFound() {
        Long studentId = 1L;
        Student foundStudent = studentService.findStudentByStudentId(studentId);
        assertEquals(studentId, foundStudent.getStudentId());
    }

}