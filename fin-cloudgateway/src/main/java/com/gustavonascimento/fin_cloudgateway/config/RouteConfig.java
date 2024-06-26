package com.gustavonascimento.fin_cloudgateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {

	@Bean
	public RouteLocator routes(RouteLocatorBuilder builder) {
		return builder.routes().route(r -> r.path("/clients/**").uri("lb://fin-clientes"))
				.route(r -> r.path("/cartoes/**").uri("lb://fin-cartoes"))
				.route(r -> r.path("/avaliacoes-credito/**").uri("lb://fin-avaliador")).build();
	}
}
