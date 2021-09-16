package com.rybaq.university.service.impl;

import com.rybaq.university.entity.Student;
import com.rybaq.university.repository.GroupRepository;
import com.rybaq.university.repository.StudentPaginationRepository;
import com.rybaq.university.repository.StudentRepository;
import com.rybaq.university.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentPaginationRepository studentPaginationRepository;
    private final StudentRepository studentRepository;
    private final GroupRepository groupRepository;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> findAllWithPagination(int page, int size) {
        return studentPaginationRepository.findAll(PageRequest.of(page, size)).toList();
    }

    @Override
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        Student student = studentRepository.getById(id);
        student.getGroup().getStudents().remove(student);
        student.setGroup(null);
        studentRepository.deleteById(id);
    }

    @Override
    public Optional<Student> create(Student student) {
        Student savedStudent = studentRepository.save(student);
        return Optional.of(savedStudent);
    }
}
