package com.hysky.cloud.config;

import com.hysky.config.RibbonConfiguration;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@org.springframework.context.annotation.Configuration
@RibbonClient(name="microservice-provider-user",configuration = RibbonConfiguration.class)
public class Configuration {


    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
