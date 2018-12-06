package com.dchealth.repository;

import com.dchealth.entity.WxUser;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WxUserRepo extends PagingAndSortingRepository<WxUser,String> {
}
