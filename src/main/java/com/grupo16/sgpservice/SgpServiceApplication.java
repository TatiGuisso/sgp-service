package com.grupo16.sgpservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SgpServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SgpServiceApplication.class, args);
	}

}
