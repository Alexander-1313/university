package com.rybaq.university.repository;

import com.rybaq.university.entity.Teacher;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherPaginationRepository extends PagingAndSortingRepository<Teacher, Long> {
}
