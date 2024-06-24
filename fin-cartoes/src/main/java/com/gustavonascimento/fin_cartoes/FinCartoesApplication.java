package com.gustavonascimento.fin_cartoes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FinCartoesApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinCartoesApplication.class, args);
	}

}
