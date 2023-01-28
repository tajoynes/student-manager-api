package com.edu.api.manager.services.impl;

import com.edu.api.manager.exception.ResourceNotFoundException;
import com.edu.api.manager.models.Student;
import com.edu.api.manager.repository.StudentRepository;
import com.edu.api.manager.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student updateStudent(Long studentId, Student student) throws ResourceNotFoundException {
        if (!studentRepository.findById(studentId).isPresent()) {
            throw new ResourceNotFoundException("Cannot find student with that Id");
        }
        Student updateStudent = studentRepository.findById(studentId).get();

        if (Objects.nonNull(student.getFirstName()) && !" ".equalsIgnoreCase(student.getFirstName())){
            updateStudent.setFirstName(student.getFirstName());
        }

        if (Objects.nonNull(student.getLastName()) && !" ".equalsIgnoreCase(student.getLastName())) {
            updateStudent.setLastName(student.getLastName());
        }

        return studentRepository.save(updateStudent);
    }

    @Override
    public void deleteStudent(Long studentId) throws ResourceNotFoundException {
        if(!studentRepository.findById(studentId).isPresent()) {
            throw new ResourceNotFoundException("Cannot find student with that Id");
        }
        studentRepository.deleteById(studentId);
    }

    @Override
    public List<Student> findStudentsByLastName(String lastName) {
        return studentRepository.findStudentsByLastName(lastName);
    }

    @Override
    public Student findStudentByStudentId(Long studentId) {
        return studentRepository.findStudentByStudentId(studentId);
    }

}
