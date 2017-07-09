package com.hysky.cloud.controller;

import com.hysky.cloud.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MovieController {

    private static final Logger log = LoggerFactory.getLogger(MovieController.class);

   // @Bean
    //@LoadBalanced
//    public RestTemplate restTemplate(){
//        return new RestTemplate();
//    }

    @Autowired
    public RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("user/{id}")
    public User findUserById(@PathVariable Long id){


        ServiceInstance serviceInstance = this.loadBalancerClient.choose("microservice-provider-user");
        //打印当前选择的是那个节点
        log.info("{}:{}:{}",serviceInstance.getServiceId(),serviceInstance.getHost(),serviceInstance.getPort());

        return restTemplate.getForObject("http://microservice-provider-user/"+id,User.class);
    }

    @GetMapping("/log-instance")
    public void logUserInstance(){
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("microservice-provider-user");
        //打印当前选择的是那个节点
        log.info("{}:{}:{}",serviceInstance.getServiceId(),serviceInstance.getHost(),serviceInstance.getPort());
    }
}
