package com.hysky.cloud.controller;

import com.hysky.cloud.model.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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

    @Autowired
    public RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

//    @HystrixCommand(fallbackMethod = "findByIdFallBack",
//        commandProperties = {
//            @HystrixProperty(
//                    name = "execution.isolation.thread.timeoutInMilliseconds",
//                    value="5000"
//           ),
//                @HystrixProperty(name="metrics.rollingStats.timeInMilliseconds",
//                value = "10000")
//        }
//    )



    @HystrixCommand(fallbackMethod = "findByIdFallBack")
    @GetMapping("user/{id}")
    public User findUserById(@PathVariable Long id){
        return restTemplate.getForObject("http://microservice-provider-user/"+id,User.class);
    }

    public User findByIdFallBack(Long id){
        User user = new User();
        user.setId(-1L);
        user.setName("默认用户");
        return user;
    }

    @GetMapping("/log-instance")
    public void logUserInstance(){
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("MICROSERVICE-PROVIDER-USER");
        //打印当前选择的是那个节点
        log.info("{}:{}:{}",serviceInstance.getServiceId(),serviceInstance.getHost(),serviceInstance.getPort());
    }
}
