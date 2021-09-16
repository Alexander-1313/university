package com.rybaq.university.service.impl;

import com.rybaq.university.entity.Student;
import com.rybaq.university.repository.StudentRepository;
import com.rybaq.university.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class StudentServiceImplTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentServiceImpl studentService;

    private final Student student = new Student();

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
        student.setBirthday(LocalDate.now());
        student.setLastName("Rybak");
        student.setFirstName("Alexander");
    }

    @Test
    void findById() {
        when(studentRepository.findById(anyLong())).thenReturn(Optional.of(student));
        Optional<Student> studentById = studentService.findById(anyLong());

        assertEquals(studentById.get(), student);
    }

    @Test
    void create() {
        when(studentRepository.save(student)).thenReturn(student);
        Optional<Student> createdStudent = studentService.create(this.student);

        assertEquals(createdStudent.get(), student);
    }
}