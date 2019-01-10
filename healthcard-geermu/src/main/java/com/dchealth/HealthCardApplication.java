package com.dchealth;

import com.dchealth.config.SystemProperties;
import com.dchealth.healthcard.service.SOAPConnector;
import com.dchealth.healthcard.soapclient.GetServerDateTime;
import com.dchealth.healthcard.soapclient.GetServerDateTimeResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@SpringBootApplication
@EnableConfigurationProperties(value = SystemProperties.class)
@EnableSwagger2
@ComponentScan("com.dchealth")
public class HealthCardApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthCardApplication.class, args);
	}

	@Bean
	CommandLineRunner lookup(SOAPConnector soapConnector) {
		return args -> {
			String name = "Sajal";//Default Name
			if(args.length>0){
				name = args[0];
			}
			GetServerDateTime request = new GetServerDateTime();
			GetServerDateTimeResponse response =(GetServerDateTimeResponse) soapConnector.callWebService("http://192.168.40.142:8888/SingleLoginSrv.asmx", request);
			System.out.println("Got Response As below ========= : ");
			System.out.println("Name : "+response.getGetServerDateTimeResult().toString());
		};
	}


}
