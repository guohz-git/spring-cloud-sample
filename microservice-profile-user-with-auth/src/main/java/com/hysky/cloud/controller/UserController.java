package com.hysky.cloud.controller;

import com.hysky.cloud.dao.UserRepository;
import com.hysky.cloud.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id){
        Object pricipal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if(pricipal instanceof UserDetails){
            UserDetails user = (UserDetails)pricipal;
            Collection<? extends GrantedAuthority> collection = user.getAuthorities();
            for(GrantedAuthority c : collection){

                //打印当前用户登录信息
                log.info("当前用户是{}，角色是{}",user.getUsername(),c.getAuthority());
            }
        }else{
            //do other thing
        }
        User user = this.userRepository.findOne(id);
        return user;
    }
}
