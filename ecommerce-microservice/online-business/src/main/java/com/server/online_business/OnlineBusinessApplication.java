package com.server.online_business;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class OnlineBusinessApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineBusinessApplication.class, args);
	}

}
