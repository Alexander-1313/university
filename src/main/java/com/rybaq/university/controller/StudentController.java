package com.rybaq.university.controller;

import com.rybaq.university.entity.Student;
import com.rybaq.university.exception.ResourceNotFoundException;
import com.rybaq.university.repository.StudentPaginationRepository;
import com.rybaq.university.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping(value = "/students", params = {"page", "size"})
    public ResponseEntity<List<Student>> findAllWithPagination(@RequestParam("page") int page, @RequestParam("size") int size){
        return new ResponseEntity<>(studentService.findAllWithPagination(page, size), HttpStatus.OK);
    }

    @GetMapping(value = "/students/all")
    public ResponseEntity<List<Student>> findAll(){
        return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/student", params = "id")
    public ResponseEntity<Student> findById(@RequestParam("id") Long id) throws ResourceNotFoundException {
        Student student = studentService.findById(id).orElseThrow(() -> new ResourceNotFoundException("student was not found!"));
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) throws ResourceNotFoundException {
        Student savedStudent = studentService.create(student).orElseThrow(() -> new ResourceNotFoundException("student was not created!"));
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/delete", params = "id")
    public ResponseEntity<String> deleteStudentById(@RequestParam("id") Long id){
        studentService.deleteById(id);
        return new ResponseEntity<>("student was deleted", HttpStatus.OK);
    }
}
