package com.infnet.taxService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.infnet.taxService.client")
public class taxServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(taxServiceApplication.class, args);
	}

}
