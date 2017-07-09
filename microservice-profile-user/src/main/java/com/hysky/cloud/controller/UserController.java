package com.hysky.cloud.controller;

import com.hysky.cloud.dao.UserRepository;
import com.hysky.cloud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id){
        User user = this.userRepository.findOne(id);
        return user;
    }

    @GetMapping("/api/{id}")
    public User findByApiId(@PathVariable Long id){
        User user = this.userRepository.findOne(id);
        user.setName("api-name");
        return user;
    }
}
