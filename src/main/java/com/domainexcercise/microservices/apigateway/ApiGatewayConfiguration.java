package com.domainexcercise.microservices.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {
	
	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p.path("/attendance-consumer/**")
						.uri("http://localhost:8180/attendance-consumer"))
						//.uri("lb://attendance-consumer"))
				.route(p -> p.path("/event-store/**")
						.uri("http://localhost:8888/event-store"))
						//.uri("lb://currency-exchange"))
				.build();
	}

}
