package com.rybaq.university.repository;

import com.rybaq.university.entity.Student;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentPaginationRepository extends PagingAndSortingRepository<Student, Long> {
}
