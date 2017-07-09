package com.hysky.cloud.user.feign;

import com.hysky.cloud.com.hysky.config.FeignLogConfiguration;
import com.hysky.cloud.user.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "microservice-provider-user",configuration = FeignLogConfiguration.class)
public interface UserFeignClient {

  @GetMapping("/{id}")
  public User findById(@PathVariable("id") Long id);
}
