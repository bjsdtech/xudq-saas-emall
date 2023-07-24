package com.xudq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;

@SpringBootApplication/*(exclude = {GlobalTransactionAutoConfiguration.class})*/
@EnableFeignClients
public class EmallOrderApplication {

	private static ApplicationContext applicationContext;

	public static void main(String[] args) {
		applicationContext = SpringApplication.run(EmallOrderApplication.class, args);
	}

	public static <T> T getBean(String beanName) {
		return applicationContext != null ? (T) applicationContext.getBean(beanName) : null;
	}
}
