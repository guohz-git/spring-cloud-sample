package com.hysky.cloud.user.feign;

import com.hysky.cloud.user.entity.User;
import com.hysky.config.FeginConfiguration;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "microservice-provider-user",configuration = FeginConfiguration.class)
public interface UserFeignClient {

  /**
   * 使用feign自带的注解@RequestLine
   * @param id
   * @return
   */
  @RequestLine("GET /{id}")
  public User findById(@PathVariable("id") Long id);
}
