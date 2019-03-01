package com.dchealth;

import com.dchealth.config.SystemProperties;
import com.dchealth.entity.MedicalCard;
import com.dchealth.repository.MedicalCardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@SpringBootApplication
@EnableConfigurationProperties(value = SystemProperties.class)
@EnableSwagger2
//@EnableTransactionManagement
public class WxMpApplication {

	public static void main(String[] args) {
		SpringApplication.run(WxMpApplication.class, args);
	}


	@Autowired
	private MedicalCardRepo medicalCardRepo ;

	@GetMapping("/test")
	@ResponseStatus(HttpStatus.OK)
	@Transactional
	public void createMedicalCard(){
		MedicalCard medicalCard = new MedicalCard();
		medicalCard.setAddress("11");
		medicalCardRepo.save(medicalCard);
//		int i = 1/0;
		MedicalCard medicalCard1 = new MedicalCard();
		medicalCard1.setAddress("111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");
		medicalCardRepo.save(medicalCard1);
		System.out.println("我是创建成功的。奶奶的胸");
	}

}
