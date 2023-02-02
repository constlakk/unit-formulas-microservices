package com.kostaslakkas.microservices.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

	//Custom Routes
	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		
		return builder.routes()
				.route(p -> p.path("/unit-formulas/**").uri("lb://unit-formulas"))
				.route(p -> p.path("/unit-conversion/**").uri("lb://unit-conversion"))
				.route(p -> p.path("/unit-conversion-feign/**").uri("lb://unit-conversion"))
				.build();
		
	}
	
}
