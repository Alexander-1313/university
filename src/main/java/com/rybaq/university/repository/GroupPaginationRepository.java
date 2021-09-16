package com.rybaq.university.repository;

import com.rybaq.university.entity.Group;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupPaginationRepository extends PagingAndSortingRepository<Group, Long> {
}
