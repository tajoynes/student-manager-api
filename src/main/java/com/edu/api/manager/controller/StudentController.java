package com.edu.api.manager.controller;

import com.edu.api.manager.exception.ResourceNotFoundException;
import com.edu.api.manager.models.Student;
import com.edu.api.manager.repository.StudentRepository;
import com.edu.api.manager.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/api/v1/students/create")
    public Student createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }

    @GetMapping("/api/v1/students")
    public List<Student> fetchStudents(){
        return studentService.getStudents();
    }

    @PutMapping("/api/v1/students/{id}")
    public Student updateStudent(@PathVariable("id")Long studentId, @RequestBody Student student) throws ResourceNotFoundException{
        return studentService.updateStudent(studentId, student);
    }

    @DeleteMapping("/api/v1/students/{id}")
    public String deleteStudent(@PathVariable("id")Long studentId) throws ResourceNotFoundException {
        studentService.deleteStudent(studentId);
        return "Student with Id: " + studentId +" was deleted";
    }

    @GetMapping("/api/v1/students/name/{name}")
    public List<Student> findStudentsByLastName(@PathVariable("name")String lastName){
       return studentService.findStudentsByLastName(lastName);
    }

    @GetMapping("/api/v1/students/{id}")
    public Student findStudentById(@PathVariable("id")Long studentId){
        return studentService.findStudentByStudentId(studentId);
    }
}
