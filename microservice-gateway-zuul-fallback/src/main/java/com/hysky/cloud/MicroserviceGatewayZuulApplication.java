package com.hysky.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringBootApplication
public class MicroserviceGatewayZuulApplication {



	public static void main(String[] args) {
		SpringApplication.run(MicroserviceGatewayZuulApplication.class, args);
	}
}
