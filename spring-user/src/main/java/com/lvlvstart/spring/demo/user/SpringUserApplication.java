package com.lvlvstart.spring.demo.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringUserApplication.class, args);
	}

}
