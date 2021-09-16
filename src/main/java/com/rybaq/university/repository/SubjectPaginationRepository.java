package com.rybaq.university.repository;

import com.rybaq.university.entity.Subject;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectPaginationRepository extends PagingAndSortingRepository<Subject, Long> {
}
