package com.hysky.cloud.user.controller;

import com.hysky.cloud.user.entity.User;
import com.hysky.cloud.user.feign.UserFeignClient;
import feign.Client;
import feign.Contract;
import feign.Feign;
import feign.auth.BasicAuthRequestInterceptor;
import feign.codec.Decoder;
import feign.codec.Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClientsConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@Import(FeignClientsConfiguration.class)
@RestController
public class UserController {

    private UserFeignClient userFeignClient;
    private UserFeignClient adminFeignClient;

    @Autowired
    public UserController(Decoder decoder, Encoder encoder, Client client
    , Contract contract) {
        this.userFeignClient = Feign.builder().client(client).encoder(encoder).decoder(decoder)
                .contract(contract).requestInterceptor(new BasicAuthRequestInterceptor("user","password1"))
                .target(UserFeignClient.class,"http://microservice-provider-with-user-auth/");
        this.adminFeignClient = Feign.builder().client(client).encoder(encoder).decoder(decoder)
                .contract(contract).requestInterceptor(new BasicAuthRequestInterceptor("admin","password1"))
                .target(UserFeignClient.class,"http://microservice-provider-with-user-auth/");
    }

    @GetMapping("/user-user/{id}")
    public User findByIdUser(@PathVariable Long id){
        return this.userFeignClient.findById(id);
    }
    @GetMapping("/user-admin/{id}")
    public User findByIdAdmin(@PathVariable Long id){
        return this.adminFeignClient.findById(id);
    }
}
