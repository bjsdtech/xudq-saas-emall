package com.xudq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EmallCouponsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmallCouponsApplication.class, args);
	}

}
