package com.lvlvstart.spring.demo.school;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
public class SpringSchoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSchoolApplication.class, args);
	}

}
