package com.hysky.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class MicroserviceSimpleConsumerMovieApplication {


	@Bean
	public RestTemplate restTemple(){
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceSimpleConsumerMovieApplication.class, args);
	}
}
