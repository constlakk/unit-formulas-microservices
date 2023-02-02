package com.kostaslakkas.microservices.unitconversion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class UnitConversionApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnitConversionApplication.class, args);
	}

}
