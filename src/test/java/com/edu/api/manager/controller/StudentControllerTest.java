package com.edu.api.manager.controller;

import com.edu.api.manager.models.Student;
import com.edu.api.manager.services.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(StudentController.class)
class StudentControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private StudentService studentService;

    private Student student;
    @BeforeEach
    void setUp() {
        student = Student.builder().studentId(1L).firstName("Steve").lastName("Smith").build();
    }

    @Test
    void createStudent() throws Exception {
        Student inputStudent =  Student.builder().firstName("Steve").lastName("Smith").build();

        Mockito.when(studentService.createStudent(inputStudent)).thenReturn(student);

        mockMvc.perform(post("/api/v1/students/create").contentType(MediaType.APPLICATION_JSON).content("{\n" +
                "    \"firstName\": \"Steve\",\n" +
                "    \"lastName\": \"Smith\"\n" +
                "}")).andExpect(status().isOk());
    }

    @Test
    void findStudentById() throws Exception {
        Mockito.when(studentService.findStudentByStudentId(1L)).thenReturn(student);
        mockMvc.perform(get("/api/v1/students/1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(jsonPath("$.lastName").value(student.getLastName()));
    }
}