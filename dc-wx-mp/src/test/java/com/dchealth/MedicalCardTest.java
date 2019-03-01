package com.dchealth;

import com.dchealth.entity.MedicalCard;
import com.dchealth.repository.MedicalCardRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest()
@RunWith(SpringJUnit4ClassRunner.class)
public class MedicalCardTest {

    @Autowired
    private MedicalCardRepo medicalCardRepo ;


    @Test
    @Rollback(false)
    @Transactional
    public void whenAddMedicalCard(){
        MedicalCard medicalCard = new MedicalCard();
        medicalCard.setAddress("11");
        medicalCardRepo.save(medicalCard);
        int i = 1/0;
        MedicalCard medicalCard1 = new MedicalCard();
        medicalCard1.setAddress("111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");
        medicalCardRepo.save(medicalCard1);
    }

}
