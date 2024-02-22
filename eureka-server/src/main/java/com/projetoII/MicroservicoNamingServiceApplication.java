package com.projetoII;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class MicroservicoNamingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicoNamingServiceApplication.class, args);
	}

}
