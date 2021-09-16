package com.rybaq.university.service;

import com.rybaq.university.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<Student> findAll();

    List<Student> findAllWithPagination(int page, int size);

    Optional<Student> findById(Long id);

    void deleteById(Long id);

    Optional<Student> create(Student student);
}
