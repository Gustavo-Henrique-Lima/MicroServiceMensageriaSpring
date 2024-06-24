package com.gustavonascimento.fin_avaliador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FinAvaliadorApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinAvaliadorApplication.class, args);
	}

}
