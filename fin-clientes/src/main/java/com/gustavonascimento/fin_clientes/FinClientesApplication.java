package com.gustavonascimento.fin_clientes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FinClientesApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinClientesApplication.class, args);
	}

}
