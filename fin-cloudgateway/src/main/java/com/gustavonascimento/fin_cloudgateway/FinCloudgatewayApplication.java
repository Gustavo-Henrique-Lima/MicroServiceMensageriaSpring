package com.gustavonascimento.fin_cloudgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FinCloudgatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinCloudgatewayApplication.class, args);
	}
	
}