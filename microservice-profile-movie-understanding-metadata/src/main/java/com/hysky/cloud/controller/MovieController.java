package com.hysky.cloud.controller;

import com.hysky.cloud.model.User;
import com.netflix.appinfo.InstanceInfo;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class MovieController {


    @Autowired
    private DiscoveryClient discoveryClient;


    @GetMapping("/user-instance")
    public List<ServiceInstance> showInfo(){
        return this.discoveryClient.getInstances("MICROSERVICE-PROVIDER-USER");
    }
}
