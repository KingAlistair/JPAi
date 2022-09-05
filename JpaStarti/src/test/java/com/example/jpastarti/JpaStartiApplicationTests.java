package com.example.jpastarti;

import com.example.jpastarti.model.Student;
import com.example.jpastarti.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@DataJpaTest
class JpaStartiApplicationTests {

    @Autowired
    StudentRepository studentRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void testStudent() {
        Student std1 = new Student();
        std1.setBorn(LocalDate.now());
        std1.setName("Annex");
        studentRepository.save(std1);

        Student std2 = new Student();
        std2.setBorn(LocalDate.now());
        std2.setName("Viggo");
        studentRepository.save(std2);

        List<Student> lst = studentRepository.findAll();
        assertEquals(0, lst.size());

        studentRepository.delete(std1);
        lst = studentRepository.findAll();
        assertEquals(1, lst.size());


    }

}