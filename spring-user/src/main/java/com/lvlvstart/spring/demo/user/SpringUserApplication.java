package com.lvlvstart.spring.demo.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients("com.lvlvstart.spring.demo.common.client")
@EnableCircuitBreaker //熔断器注解
public class SpringUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringUserApplication.class, args);
	}

}
