package com.dchealth;

import com.dchealth.config.SystemProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@SpringBootApplication
@EnableConfigurationProperties(value = SystemProperties.class)
@EnableSwagger2
@EnableTransactionManagement
public class WxMpApplication {

	public static void main(String[] args) {
		SpringApplication.run(WxMpApplication.class, args);
	}



}
