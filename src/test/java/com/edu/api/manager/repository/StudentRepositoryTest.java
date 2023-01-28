package com.edu.api.manager.repository;

import com.edu.api.manager.models.Student;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TestEntityManager entityManager;
    @BeforeEach
    void setUp() {
        Student newStudent = Student.builder().firstName("Jason").lastName("Smith").build();
        entityManager.persist(newStudent);
    }
    @Test
    @DisplayName("Find Student by Last Name")
    public void whenFindByLastName_thenReturnStudent(){
        Student student = studentRepository.findStudentsByLastName("Smith").get(0);
        assertEquals(student.getLastName(), "Smith");
    }

//    @Test
//    @DisplayName("Find Student By ID")
//    public void whenFindByID_returnStudent(){
//        Student student = studentRepository.findById(1L).get();
//        assertEquals(student.getStudentId(), 1L );
//    }
}