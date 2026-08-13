package com.example.recovery_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableFeignClients
@EnableScheduling
@SpringBootApplication
public class RecoveryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecoveryServiceApplication.class, args);
	}

}
