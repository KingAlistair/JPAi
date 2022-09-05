package com.example.jpastarti.controller;

import com.example.jpastarti.model.Student;
import com.example.jpastarti.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
public class StudentRestController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/students")
    public List<Student> students() {
       return studentRepository.findAll();
    }


    @GetMapping("/addstudent")
    public List<Student> addStudent() {
        Student student = new Student();
        student.setName("Billy");
        student.setBorn(LocalDate.now());
        student.setBornTime(LocalTime.now());
        List<Student> studentList = studentRepository.findAll();

        studentRepository.save(student);

        return studentList;
    }
}


