package com.dchealth.service;

import com.dchealth.entity.MedicalCard;
import com.dchealth.repository.MedicalCardRepo;
import com.dchealth.service.base.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalCardService extends BaseService<MedicalCard,String,MedicalCardRepo>{
    /**
     * 根据OpenId获取所有的类
     * @param openId
     * @return
     */
    public List<MedicalCard> findMedicalCardsByOpenId(String openId) {
        return this.repository.findAllByOpenId(openId);
    }


}
