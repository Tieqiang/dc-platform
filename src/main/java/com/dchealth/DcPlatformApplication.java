package com.dchealth;

import com.dchealth.config.SystemProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@SpringBootApplication
@EnableConfigurationProperties(value = SystemProperties.class)
@ComponentScan(basePackages = "com.dchealth")
@EnableSwagger2
public class DcPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(DcPlatformApplication.class, args);
	}


}
