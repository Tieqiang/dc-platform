package com.dchealth.repository;

import com.dchealth.entity.MedicalCard;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicalCardRepo extends PagingAndSortingRepository<MedicalCard,String> {

    List<MedicalCard> findAllByOpenId(String openId);

}
