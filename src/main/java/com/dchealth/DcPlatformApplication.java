package com.dchealth;

import com.dchealth.config.SystemProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(value = SystemProperties.class)
public class DcPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(DcPlatformApplication.class, args);
	}


}
