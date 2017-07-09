package com.hysky.cloud;

import com.hysky.cloud.filter.PreRrequestLogFile;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringBootApplication
public class MicroserviceGatewayZuulApplication {


	@Bean
	public PreRrequestLogFile preRrequestLogFile(){
		return new PreRrequestLogFile();
	}

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceGatewayZuulApplication.class, args);
	}
}
