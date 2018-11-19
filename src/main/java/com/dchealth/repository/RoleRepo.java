package com.dchealth.repository;

import com.dchealth.entity.Role;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends PagingAndSortingRepository<Role,String> {
}
